/*
 Navicat Premium Data Transfer

 Source Server         : ponny
 Source Server Type    : MySQL
 Source Server Version : 100411
 Source Host           : localhost:3306
 Source Schema         : androidcrud

 Target Server Type    : MySQL
 Target Server Version : 100411
 File Encoding         : 65001

 Date: 30/11/2020 22:02:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mahasiswa
-- ----------------------------
DROP TABLE IF EXISTS `mahasiswa`;
CREATE TABLE `mahasiswa`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nim` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `nama` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `prodi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp(0) NULL DEFAULT NULL,
  `updated_at` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mahasiswa
-- ----------------------------
INSERT INTO `mahasiswa` VALUES (1, '18051204059', 'Muhammad Alfian Ma\'ruf', 'Teknik Informatika', '2020-11-29 07:32:26', '2020-11-30 13:15:02');
INSERT INTO `mahasiswa` VALUES (13, '18051204851', 'Jessica Handayani', 'Teknik Informatika', NULL, '2020-11-30 14:53:33');
INSERT INTO `mahasiswa` VALUES (14, '18051204200', 'Eja Thamrin S.T.', 'Teknik Informatika', NULL, NULL);
INSERT INTO `mahasiswa` VALUES (15, '18051204516', 'Prayoga Marpaung S.T.', 'Teknik Informatika', NULL, NULL);
INSERT INTO `mahasiswa` VALUES (16, '18051204053', 'Jumari Mandala S.Ked', 'Teknik Informatika', NULL, NULL);
INSERT INTO `mahasiswa` VALUES (17, '18051204410', 'Kusuma Gada Irawan', 'Teknik Informatika', NULL, NULL);
INSERT INTO `mahasiswa` VALUES (18, '18051204067', 'Bambang Dadi Narpati S.E.I', 'Teknik Informatika', NULL, NULL);
INSERT INTO `mahasiswa` VALUES (19, '18051204839', 'Tania Ade Mandasari M.Ak', 'Teknik Informatika', NULL, NULL);
INSERT INTO `mahasiswa` VALUES (20, '18051204133', 'Restu Wulan Rahimah', 'Teknik Informatika', NULL, NULL);
INSERT INTO `mahasiswa` VALUES (21, '18051204485', 'Jamil Raihan Permadi S.Sos', 'Teknik Informatika', NULL, NULL);
INSERT INTO `mahasiswa` VALUES (22, '18051204202', 'Panji Salahudin', 'Teknik Informatika', NULL, NULL);
INSERT INTO `mahasiswa` VALUES (53, '18051204059', 'Muhammad Alfian Ma\'ruf', 'Teknik Informatika', '2020-11-30 03:51:35', '2020-11-30 03:51:35');
INSERT INTO `mahasiswa` VALUES (57, '18051204059', 'Muhammad Alfian Ma\'ruf', 'Teknik Informatika', '2020-11-30 09:44:42', '2020-11-30 09:44:42');
INSERT INTO `mahasiswa` VALUES (58, '18051204002', 'Erita Putri Ramadhani', 'Teknik Informatika', '2020-11-30 09:45:08', '2020-11-30 09:45:08');
INSERT INTO `mahasiswa` VALUES (59, '18051204059', 'Muhammad Alfian Ma\'ruf', 'Teknik Informatika', '2020-11-30 09:45:31', '2020-11-30 09:45:31');

-- ----------------------------
-- Table structure for migrations
-- ----------------------------
DROP TABLE IF EXISTS `migrations`;
CREATE TABLE `migrations`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `migration` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of migrations
-- ----------------------------
INSERT INTO `migrations` VALUES (1, '2020_11_26_083917_create_mahasiswa_table', 1);

SET FOREIGN_KEY_CHECKS = 1;
