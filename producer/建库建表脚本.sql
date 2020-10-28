## 创建consumer数据库
CREATE DATABASE `producer` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
                            `id` int(0) NOT NULL AUTO_INCREMENT,
                            `msg_identical_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                            `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0：未发送 1：已发送，未返回 2：已返回，未成功 3：已返回，已成功',
                            `msg_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息内容',
                            `createtime` datetime(0) NULL DEFAULT NULL,
                            `ts` datetime(0) NULL DEFAULT NULL,
                            PRIMARY KEY (`id`, `msg_identical_id`) USING BTREE,
                            UNIQUE INDEX `msg_identical_id`(`msg_identical_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;