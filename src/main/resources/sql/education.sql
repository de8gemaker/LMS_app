/*
 Navicat Premium Data Transfer

 Source Server         : imooc_mall
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : education

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 10/04/2022 15:00:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `course_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程简介',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `course_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程类别',
  `bz` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开课标志 1开课0未开课',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程链接',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of course
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES (9, '语言', NULL, '2022-04-09 15:39:19', '语言学习', '1', 'http://192.168.3.8:8085/download?fileName=29daa412-20a8-47ac-9e3d-1ef67ec66e78.mp4'), (10, '算法', NULL, '2022-04-09 15:39:32', '算法/AI', '1', 'http://192.168.3.8:8085/download?fileName=51698b9b-d40f-4aa8-b52a-2b742f28f65c.mp4'), (11, '硬件', NULL, '2022-04-09 15:39:43', '硬件编程', '1', 'http://192.168.3.8:8085/download?fileName=e48bb3e7-3055-46b2-bf07-fdaf1eafce5b.mp4');
COMMIT;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '班级名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of grade
-- ----------------------------
BEGIN;
INSERT INTO `grade` VALUES (7, '编程班级1', '2022-04-10 14:28:03'), (8, '编程班级2', '2022-04-10 14:28:17'), (10, '算法班级3', '2022-04-10 14:28:44');
COMMIT;

-- ----------------------------
-- Table structure for study_record
-- ----------------------------
DROP TABLE IF EXISTS `study_record`;
CREATE TABLE `study_record`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(10) NULL DEFAULT NULL COMMENT '用户id',
  `course_id` bigint(10) NULL DEFAULT NULL COMMENT '课程id',
  `course_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of study_record
-- ----------------------------
BEGIN;
INSERT INTO `study_record` VALUES (6, 2, 9, NULL, '2022-04-09 15:40:27'), (7, 2, 10, NULL, '2022-04-09 15:40:31'), (8, 8539, 9, NULL, '2022-04-10 12:47:12'), (9, 8539, 10, NULL, '2022-04-10 12:47:21'), (10, 9897, 9, NULL, '2022-04-10 14:35:38'), (11, 9897, 11, NULL, '2022-04-10 14:38:11');
COMMIT;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` bigint(10) NOT NULL COMMENT 'id',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `type` int(1) NULL DEFAULT NULL COMMENT '类型1 管理员  2学生   3 老师',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `grade_id` bigint(10) NULL DEFAULT NULL COMMENT '班级id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of user_info
-- ----------------------------
BEGIN;
INSERT INTO `user_info` VALUES (1, '1', '1', '1', 1, NULL, NULL), (3100, NULL, '4', '4', 2, '2022-04-10 14:31:48', 8), (3299, NULL, '3', '3', 3, '2022-04-10 14:29:01', NULL), (6424, '', '3', '666', 2, '2022-04-10 14:37:10', 7), (9897, '', '2', '2', 2, '2022-04-10 14:32:42', 10);
COMMIT;

-- ----------------------------
-- Table structure for works
-- ----------------------------
DROP TABLE IF EXISTS `works`;
CREATE TABLE `works`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '作品id',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '作品名称',
  `content` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '作品内容',
  `student_id` bigint(10) NULL DEFAULT NULL COMMENT '学生id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of works
-- ----------------------------
BEGIN;
INSERT INTO `works` VALUES (5, '学习情况', '李吉里吉里\n小祖宗\n嘻嘻嘻嘻嘻嘻\n', 9897, '2022-04-10 14:35:33'), (6, '算法编写', 'hdhjdjdjjd\nhdhdhhd\nhdhhdhd\nhdh\ndhhdjjjdnd\ndhhd', 9897, '2022-04-10 14:38:35');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
