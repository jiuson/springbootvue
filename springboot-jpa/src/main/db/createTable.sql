CREATE TABLE `tb_user` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'md5加密后的密码',
  `address` text NOT NULL,
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `modify_date` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tb_token` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(10) NOT NULL COMMENT 'tb_user_id',
  `token` varchar(255) DEFAULT NULL COMMENT 'token',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `expire_date` datetime DEFAULT NULL COMMENT '过期时间（一个月）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tb_consume` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `consume_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `expenditure` float NOT NULL,
  `consume_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `consume_date` datetime NOT NULL,
  `modify_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
