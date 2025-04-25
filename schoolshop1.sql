/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80200
 Source Host           : localhost:3306
 Source Schema         : schoolshop1

 Target Server Type    : MySQL
 Target Server Version : 80200
 File Encoding         : 65001

 Date: 25/04/2025 13:06:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address_management
-- ----------------------------
DROP TABLE IF EXISTS `address_management`;
CREATE TABLE `address_management`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NULL DEFAULT NULL,
  `delivery_address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `delivery_phone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `delivery_person_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `address_management_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_account` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address_management
-- ----------------------------
INSERT INTO `address_management` VALUES (1, 1, '北京市市辖区朝阳区1', '19562228975', '张三');
INSERT INTO `address_management` VALUES (2, 1, '湖南省株洲市荷塘区11111', '19065428093', '李四');
INSERT INTO `address_management` VALUES (4, 4, '天津市市辖区河东区1', '19562228975', '王五');

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '111', '111111');

-- ----------------------------
-- Table structure for announcements
-- ----------------------------
DROP TABLE IF EXISTS `announcements`;
CREATE TABLE `announcements`  (
  `announcement_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `status` enum('活动','通知','最新','紧急') CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `publish_date` datetime(0) NOT NULL,
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`announcement_id`) USING BTREE,
  INDEX `idx_status`(`status`) USING BTREE,
  INDEX `idx_publish_date`(`publish_date`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of announcements
-- ----------------------------
INSERT INTO `announcements` VALUES (1, '活动', '春季新品上市', '2025-03-12 20:17:25', '欢迎光临我们的商城，春季新品已上线，快来选购吧！');
INSERT INTO `announcements` VALUES (2, '紧急', '紧急维护通知', '2025-03-12 20:17:25', '今晚12点至凌晨2点，商城将进行系统维护，期间无法访问，敬请谅解。');
INSERT INTO `announcements` VALUES (3, '通知', '会员日活动', '2025-03-12 20:17:25', '每月的最后一个星期五是会员日，会员可享受专属折扣，不要错过！');
INSERT INTO `announcements` VALUES (4, '最新', '最新促销信息', '2025-03-12 20:17:25', '即日起至本周末，全场商品8折优惠，机不可失，时不再来！');
INSERT INTO `announcements` VALUES (6, '活动', '春季新品上市', '2025-03-12 12:35:29', '欢迎光临我们的商城，春季新品已上线，快来选购吧！111');
INSERT INTO `announcements` VALUES (7, '紧急', '紧急维护通知', '2025-03-12 20:35:29', '今晚12点至凌晨2点，商城将进行系统维护，期间无法访问，敬请谅解。');
INSERT INTO `announcements` VALUES (8, '通知', '会员日活动', '2025-03-12 20:35:29', '每月的最后一个星期五是会员日，会员可享受专属折扣，不要错过！');
INSERT INTO `announcements` VALUES (9, '最新', '最新促销信息', '2025-03-12 20:35:29', '即日起至本周末，全场商品8折优惠，机不可失，时不再来！');

-- ----------------------------
-- Table structure for carts
-- ----------------------------
DROP TABLE IF EXISTS `carts`;
CREATE TABLE `carts`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `user_id` int(0) NOT NULL,
  `quantity` int(0) NULL DEFAULT 1,
  `created_at` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `carts_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `carts_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user_account` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carts
-- ----------------------------

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `comment_text` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL,
  `product_id` int(0) NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `score` double NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `use_key`(`user_id`) USING BTREE,
  INDEX `product_key`(`product_id`) USING BTREE,
  CONSTRAINT `product_key` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `use_key` FOREIGN KEY (`user_id`) REFERENCES `user_account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES (5, '人格如果RW', 16, 1, 'PRODUCT', 5, '/images/7b7ee138-c718-4a67-997c-6ddfc6e34dd1.jpg');
INSERT INTO `comments` VALUES (7, '发表回复好难过和你的', 14, 4, 'PRODUCT', 5, '/images/5bf4beda-8239-4d5b-a8da-863a715b33ee.png');

-- ----------------------------
-- Table structure for likes
-- ----------------------------
DROP TABLE IF EXISTS `likes`;
CREATE TABLE `likes`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `user_id` int(0) NOT NULL,
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user`(`user_id`) USING BTREE,
  INDEX `product`(`product_id`) USING BTREE,
  CONSTRAINT `product` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user` FOREIGN KEY (`user_id`) REFERENCES `user_account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of likes
-- ----------------------------
INSERT INTO `likes` VALUES (15, 16, 1, '2025-03-16 13:39:55');
INSERT INTO `likes` VALUES (16, 14, 4, '2025-03-16 20:21:31');
INSERT INTO `likes` VALUES (17, 4, 4, '2025-03-23 14:43:20');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `logistics_status` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '待发货',
  `created_at` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `number` int(0) NULL DEFAULT NULL,
  `single_price` decimal(10, 2) NULL DEFAULT NULL,
  `total_price` decimal(10, 2) NULL DEFAULT NULL,
  `address_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  INDEX `address_id`(`address_id`) USING BTREE,
  CONSTRAINT `adress_id` FOREIGN KEY (`address_id`) REFERENCES `address_management` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (22, 16, 'PENDING_SHIPMENT', '2025-03-16 15:17:12', 1, 0.30, 0.30, 2);
INSERT INTO `orders` VALUES (23, 16, 'COMPLETED', '2025-03-16 15:17:23', 1, 0.30, 0.30, 2);
INSERT INTO `orders` VALUES (24, 16, 'REFUNDED', '2025-03-16 15:35:18', 1, 0.30, 0.30, 1);
INSERT INTO `orders` VALUES (25, 14, 'PENDING_SHIPMENT', '2025-03-16 20:21:41', 2, 0.40, 0.80, 4);
INSERT INTO `orders` VALUES (26, 14, 'REFUNDED', '2025-03-16 20:21:57', 3, 0.40, 1.20, 4);
INSERT INTO `orders` VALUES (27, 4, 'COMPLETED', '2025-03-23 14:46:17', 3, 0.30, 0.90, 4);

-- ----------------------------
-- Table structure for product_detail
-- ----------------------------
DROP TABLE IF EXISTS `product_detail`;
CREATE TABLE `product_detail`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NULL DEFAULT NULL,
  `favorite_count` int(0) NULL DEFAULT NULL,
  `like_count` int(0) NULL DEFAULT NULL,
  `purchase_count` int(0) NULL DEFAULT NULL,
  `view_count` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_detail
-- ----------------------------
INSERT INTO `product_detail` VALUES (4, 14, 0, 0, 0, 5);
INSERT INTO `product_detail` VALUES (5, 16, 0, 1, 0, 139);
INSERT INTO `product_detail` VALUES (6, 4, 0, 0, 0, 42);
INSERT INTO `product_detail` VALUES (7, 5, 0, 0, 0, 1);
INSERT INTO `product_detail` VALUES (8, 6, 0, 0, 0, 0);
INSERT INTO `product_detail` VALUES (9, 7, 0, 0, 0, 1);
INSERT INTO `product_detail` VALUES (10, 18, 0, 0, 0, 1);
INSERT INTO `product_detail` VALUES (11, 19, 0, 0, 0, 1);
INSERT INTO `product_detail` VALUES (12, 20, 0, 0, 0, 1);
INSERT INTO `product_detail` VALUES (13, 21, 0, 0, 0, 0);
INSERT INTO `product_detail` VALUES (14, 22, 0, 0, 0, 0);
INSERT INTO `product_detail` VALUES (15, 23, 0, 0, 0, 0);
INSERT INTO `product_detail` VALUES (16, 24, 0, 0, 1, 5);
INSERT INTO `product_detail` VALUES (17, 25, 0, 0, 0, 0);

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products`  (
  `product_id` int(0) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `category` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  `description` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL,
  `stock` int(0) UNSIGNED NOT NULL DEFAULT 0,
  `image_url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`) USING BTREE,
  INDEX `idx_category`(`category`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES (4, '伞', 'life-ritual', 0.30, '11', 3, '/images/0506cb3c-6854-42d1-a611-5e5e5bebe0e2.jpg');
INSERT INTO `products` VALUES (5, '杯子', 'life-aesthetic', 0.10, '1', 1, '/images/2edee0e5-4fc8-40db-9592-24a33b05e7f9.png');
INSERT INTO `products` VALUES (6, '鼠标垫', 'students', 0.30, '12', 2, '/images/c757d1d7-b3e9-46ca-8ea1-31d037cfb9f2.png');
INSERT INTO `products` VALUES (7, '笔记本', 'writing', 0.20, '221', 2, '/images/66f7be64-770d-4e0a-a0b3-3784173b8d4a.png');
INSERT INTO `products` VALUES (14, '马克杯', 'life-aesthetic', 0.40, '杯子', 11, '/images/b9b318a0-2d4d-4bb3-9bc0-eeabc58bbf76.png');
INSERT INTO `products` VALUES (16, '镜子', 'life-ritual', 0.30, '镜子', 4, '/images/867edc77-895c-406a-a84b-503cfe8b3d69.jpg');
INSERT INTO `products` VALUES (18, '帆布包', 'life-aesthetic', 0.40, '帆布包', 4, '/images/5e238900-1094-4f21-8b52-464fc566b747.jpg');
INSERT INTO `products` VALUES (19, '钥匙扣', 'students', 0.40, '钥匙扣', 6, '/images/278fdcfa-dfb0-4834-b3b0-a1aa5ce41613.jpg');
INSERT INTO `products` VALUES (20, '徽章', 'life-ritual', 0.50, '徽章', 5, '/images/2937802b-b342-42e1-b2b8-1fb5f5f472db.jpg');
INSERT INTO `products` VALUES (21, '礼盒', 'life-ritual', 0.20, '礼盒', 4, '/images/71f41df8-fc4e-45ed-844e-0cc449c8da5e.png');
INSERT INTO `products` VALUES (22, '棒球帽', 'life-ritual', 0.30, '棒球帽', 7, '/images/9ff5113a-2bd2-4c48-8a2c-c3decae50d73.jpg');
INSERT INTO `products` VALUES (23, '纸杯子', 'life-ritual', 0.50, '纸杯子', 6, '/images/7639c859-0d1c-4c86-9ed1-39115d04998c.jpg');
INSERT INTO `products` VALUES (24, '马克笔', 'writing', 0.50, '笔', 12, '/images/ac11ca63-39a4-4db8-9c8c-87bd276898b5.jpg');
INSERT INTO `products` VALUES (25, '伞2', 'life-aesthetic', 0.70, '伞2', 5, '/images/e71b49a4-2784-432c-b1b9-a0ed43c9ff63.png');

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `true_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `phone_number` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `create_at` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `account`(`account`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_account
-- ----------------------------
INSERT INTO `user_account` VALUES (1, '111', '111111', '23222433@qq.com', '张三', '19627222789', '2025-03-25', '2025-03-16');
INSERT INTO `user_account` VALUES (2, '12', '12', '12', NULL, NULL, NULL, '2025-04-14');
INSERT INTO `user_account` VALUES (4, 'zd', 'zd0116...', '2322248966@qq.com', NULL, '19627846894', NULL, '2025-04-15');
INSERT INTO `user_account` VALUES (5, 'zdgbaf', '111111', '232426786@qq.com', NULL, '15787978986', NULL, '2025-04-16');

SET FOREIGN_KEY_CHECKS = 1;
