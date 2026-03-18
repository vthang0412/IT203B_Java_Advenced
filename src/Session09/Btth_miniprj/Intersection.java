package Session09.Btth_miniprj;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

// Intersection = vùng giao nhau (Critical Section)
public class Intersection {

    // PriorityBlockingQueue:
    // - Thread-safe
    // - Tự sắp xếp theo priority (xe cứu thương lên trước)
    private final PriorityBlockingQueue<Vehicle> queue = new PriorityBlockingQueue<>();

    // lưu loại xe đã qua để thống kê bằng Stream
    private final ConcurrentLinkedQueue<Vehicle> passedVehicles = new ConcurrentLinkedQueue<>();

    // Semaphore:
    // - Giới hạn số xe vào giao lộ cùng lúc
    // - Ở đây = 1 → tránh va chạm
    private final Semaphore semaphore = new Semaphore(1);

    // Sức chứa tối đa → dùng để detect kẹt xe
    private final int MAX_CAPACITY = 5;

    // Thống kê số xe đã đi qua (thread-safe)
    private final AtomicInteger passed = new AtomicInteger(0);

    // Thống kê số lần kẹt xe
    private int trafficJam = 0;

    // trạng thái kẹt xe (tránh spam log)
    private boolean isJam = false;

    // Tham chiếu đến TrafficLight
    private final TrafficLight light;

    // biến điều khiển chạy/dừng
    private volatile boolean running = true;

    // Thread xử lý chính
    private Thread worker;

    // Constructor
    public Intersection(TrafficLight light) {
        this.light = light;
    }

    // Thêm xe vào hàng đợi
    public void addVehicle(Vehicle v) throws TrafficJamException {

        // VALIDATE null
        if (v == null) {
            throw new IllegalArgumentException("Vehicle null");
        }

        // Nếu queue đầy → kẹt xe
        if (queue.size() >= MAX_CAPACITY) {

            if (!isJam) {
                trafficJam++;
                isJam = true;
                Logger.log("KẸT XE!");
            }

            throw new TrafficJamException("Jam!");
        } else {
            isJam = false;
        }

        // Gắn xe vào observer của đèn
        light.attach(v);

        // Đưa xe vào queue
        queue.offer(v);

        Logger.log(v + " vào hàng chờ");
    }

    // Xử lý xe đi qua giao lộ
    public void process() {

        // Tạo thread riêng để xử lý
        worker = new Thread(() -> {

            // chạy đến khi stop
            while (running) {
                try {

                    // ❗ KHÔNG dùng take → tránh lỗi logic
                    Vehicle v = queue.peek();

                    if (v == null) {
                        Thread.sleep(100);
                        continue;
                    }

                    // Nếu là xe thường → phải chờ đèn
                    if (!(v instanceof PriorityVehicle)) {

                        // dùng observer → không polling currentLight
                        while (!v.canGo && running) {
                            Thread.sleep(100);
                        }
                    }

                    // Lấy xe ra khỏi queue khi đã được phép đi
                    queue.poll();

                    // Acquire quyền vào giao lộ
                    semaphore.acquire();

                    // Tạo thread cho xe
                    Thread t = new Thread(v);
                    t.start();

                    // Đợi xe chạy xong (tránh release sớm)
                    t.join();

                    // Log đi qua
                    Logger.log(v + " đang đi qua ngã tư");

                    // Giả lập thời gian đi qua
                    Thread.sleep(1000);

                    // Tăng số xe đã qua
                    passed.incrementAndGet();
                    passedVehicles.add(v);

                    // Release → cho xe khác vào
                    semaphore.release();

                } catch (InterruptedException e) {

                    Thread.currentThread().interrupt();

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        });

        worker.start();
    }

    // Dừng giao lộ
    public void stop() {
        running = false;
        if (worker != null) {
            worker.interrupt();
        }
    }

    public void stats() {

        System.out.println("Passed: " + passed.get());
        System.out.println("Jam: " + trafficJam);

        System.out.println("=== Vehicle Stats ===");

        passedVehicles.stream()
                .map(v -> v.getDisplayName())
                .map(name -> name.split(" #")[0])
                .distinct()
                .forEach(type -> {

                    long count = passedVehicles.stream()
                            .map(v -> v.getDisplayName())
                            .filter(name -> name.startsWith(type))
                            .count();

                    System.out.println(type + ": " + count);
                });
    }
}