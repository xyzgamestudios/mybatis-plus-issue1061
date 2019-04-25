SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ges_admin
-- ----------------------------
DROP TABLE IF EXISTS `ges_admin`;
CREATE TABLE `ges_admin` (
  `admin_id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '主键',
  `username` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '盐',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

SET FOREIGN_KEY_CHECKS = 1;