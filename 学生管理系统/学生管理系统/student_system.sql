/*
 Navicat Premium Dump SQL

 Source Server         : taobao
 Source Server Type    : MySQL
 Source Server Version : 90100 (9.1.0)
 Source Host           : localhost:3306
 Source Schema         : student_system

 Target Server Type    : MySQL
 Target Server Version : 90100 (9.1.0)
 File Encoding         : 65001

 Date: 13/03/2026 12:37:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `position` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('09a6c1a5-598f-49a9-94f1-6e892cb698cf', '萧炎', '教务员', '12345678');
INSERT INTO `admin` VALUES ('101', '李晨曦', '校长', '12345678');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `no` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `ddd` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `time` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `num` int NULL DEFAULT NULL,
  `teacherId` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `course_teacher_id_fk`(`teacherId` ASC) USING BTREE,
  CONSTRAINT `course_teacher_id_fk` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('401', '高数', '1', '高等数学是不错的课', '2026.3.10 每周一下午', 100, '201');
INSERT INTO `course` VALUES ('68c92045-013f-4d18-9834-78042dda0940', '大学英语3', '0', '来学英语', '2026-2027-2 每周一 08:00-09:40', 10, '201');
INSERT INTO `course` VALUES ('eb3a52e5-1b01-490e-8484-eaf8722c2929', '线性代数', '1', NULL, '2026-2027-2 每周一 08:00-09:40', 10, '201');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `courseId` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `studentId` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `score` int NULL DEFAULT NULL,
  `stair` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `score_course_id_fk`(`courseId` ASC) USING BTREE,
  INDEX `score_student_id_fk`(`studentId` ASC) USING BTREE,
  CONSTRAINT `score_course_id_fk` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `score_student_id_fk` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('501', '401', '301', 90, 'A');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `sex` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `phone` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('301', '许光明', '12345678', '男', '18329183547', '1111111@qq.com', 18);

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course`  (
  `id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `studentId` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `courseId` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `no` tinyint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `student_course_student_id_fk`(`studentId` ASC) USING BTREE,
  INDEX `student_course_course_id_fk`(`courseId` ASC) USING BTREE,
  CONSTRAINT `student_course_course_id_fk` FOREIGN KEY (`courseId`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `student_course_student_id_fk` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES ('12479c17-2303-4181-bc41-181496cce01b', '301', 'eb3a52e5-1b01-490e-8484-eaf8722c2929', 1);
INSERT INTO `student_course` VALUES ('2a794bbd-ddee-46f2-9b6e-099f3d0532d2', '301', '401', 1);
INSERT INTO `student_course` VALUES ('601', '301', '401', 1);
INSERT INTO `student_course` VALUES ('682c7599-b3b3-4c2c-ab74-8049bfef50d8', '301', '401', 1);
INSERT INTO `student_course` VALUES ('cfb21ec3-fbe9-4f4b-9fea-8ba51b5b1d9f', '301', '68c92045-013f-4d18-9834-78042dda0940', 1);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `phone` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `position` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `department` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('201', '张翔', '男', '1234567891', '333334@qq.com', '教授', '计算机学院', '12345678');
INSERT INTO `teacher` VALUES ('507537b2-0334-4b49-9c1c-a98cd44bede3', '张三', '男', '18888888888', '188888888@qq.com', '副校长', '计算机学院', '18888888888');

SET FOREIGN_KEY_CHECKS = 1;
