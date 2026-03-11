package Session04.Test;

import static org.junit.jupiter.api.Assertions.*;

import Session04.Bai5.AccessControl;
import Session04.Bai5.Action;
import Session04.Bai5.Role;
import Session04.Bai5.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Bai5 {

    private AccessControl accessControl;
    private User admin;
    private User moderator;
    private User regularUser;

    @BeforeEach
    void setUp() {
        accessControl = new AccessControl();
        admin = new User("Admin", Role.ADMIN);
        moderator = new User("DekayMod", Role.MODERATOR);
        regularUser = new User("User01", Role.USER);
    }

    @AfterEach
    void tearDown() {
        admin = null;
        moderator = null;
        regularUser = null;
    }

    @Test
    @DisplayName("Kiểm tra quyền của ADMIN (Top-Down)")
    void testAdminPermissions() {
        assertAll("ADMIN có toàn quyền",
                () -> assertTrue(accessControl.canPerformAction(admin, Action.DELETE_USER), "ADMIN phải xóa được user"),
                () -> assertTrue(accessControl.canPerformAction(admin, Action.LOCK_USER), "ADMIN phải khóa được user"),
                () -> assertTrue(accessControl.canPerformAction(admin, Action.VIEW_PROFILE), "ADMIN phải xem được profile")
        );
    }

    @Test
    @DisplayName("Kiểm tra quyền của MODERATOR")
    void testModeratorPermissions() {
        assertAll("MODERATOR có quyền hạn chế",
                () -> assertFalse(accessControl.canPerformAction(moderator, Action.DELETE_USER), "MODERATOR không được xóa user"),
                () -> assertTrue(accessControl.canPerformAction(moderator, Action.LOCK_USER), "MODERATOR được quyền khóa user"),
                () -> assertTrue(accessControl.canPerformAction(moderator, Action.VIEW_PROFILE), "MODERATOR được xem profile")
        );
    }

    @Test
    @DisplayName("Kiểm tra quyền của USER")
    void testUserPermissions() {
        assertAll("USER chỉ có quyền xem",
                () -> assertFalse(accessControl.canPerformAction(regularUser, Action.DELETE_USER), "USER không được xóa"),
                () -> assertFalse(accessControl.canPerformAction(regularUser, Action.LOCK_USER), "USER không được khóa"),
                () -> assertTrue(accessControl.canPerformAction(regularUser, Action.VIEW_PROFILE), "USER được xem profile")
        );
    }
}