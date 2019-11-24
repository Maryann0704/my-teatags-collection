package dao;

import connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDataBase {

    public static void main(String[] args) throws SQLException {

        try (Connection connection = ConnectionCreator.get();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("DROP SCHEMA IF EXISTS `my_collection` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `my_collection` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `my_collection`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `my_collection`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(15) NULL,\n" +
                    "  `password` VARCHAR(100) NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `role_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  UNIQUE  `login_UNIQUE` (`login` ASC))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `my_collection`.`material` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `material` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `my_collection`.`trademark` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `trademark` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  UNIQUE  `trademark_UNIQUE` (`trademark` ASC) )\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `my_collection`.`teatags` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `trademark_id` INT NOT NULL,\n" +
                    "  `subtitle` VARCHAR(45) NULL,\n" +
                    "  `material_id` INT NOT NULL,\n" +
                    "  `width` DECIMAL NULL,\n" +
                    "  `height` DECIMAL NULL,\n" +
                    "  `in_collection_since` DATE NOT NULL,\n" +
                    "  `num_in_catalog` VARCHAR(7) NULL,\n" +
                    "  `user_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `my_collection`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `my_collection`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `my_collection`.`roles` (`id`, `role`) VALUES (DEFAULT, 'moderator');");
            statement.executeUpdate("INSERT INTO `my_collection`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `my_collection`.`users` (`id`, `login`, `password`, `email`, `role_id`) VALUES (DEFAULT, 'masha_05', '800c97bfa2be7c1b564a3237f266fa27', 'masha_05@tut.by', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`users` (`id`, `login`, `password`, `email`, `role_id`) VALUES (DEFAULT, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'best_admin@tut.by', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`users` (`id`, `login`, `password`, `email`, `role_id`) VALUES (DEFAULT, 'zhan_france', 'ce130c4c688feb67e12f59c595bfdca1', 'zhan_pol@gmail.com', 2);");
            statement.executeUpdate("INSERT INTO `my_collection`.`users` (`id`, `login`, `password`, `email`, `role_id`) VALUES (DEFAULT, 'dimon_rus', '3f3693122873361055ce5594d18687e4', 'dimas@mail.ru', 2);");
            statement.executeUpdate("INSERT INTO `my_collection`.`material` (`id`, `material`) VALUES (DEFAULT, 'cardboard');");
            statement.executeUpdate("INSERT INTO `my_collection`.`material` (`id`, `material`) VALUES (DEFAULT, 'paper');");
            statement.executeUpdate("INSERT INTO `my_collection`.`material` (`id`, `material`) VALUES (DEFAULT, 'plastic');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'AHMAD TEA');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'AKBAR');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'ALATTAR');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'AUCHAN');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'BROOKE BOND');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'CHELTON');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'DILMAH');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'FOREST OF ARDEN');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'GOLDEN BOWL');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'GREENFIELD');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'JAF TEA');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'KAKOO');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'LIPTON');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'LORD NELSON');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'MABROC');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'MAITRE DE THE');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'MALWA');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'MESSMER');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'MISTRAL');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'NATURSAN');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'PICKWICK');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'PRINCESS JAVA');");
            statement.executeUpdate("INSERT INTO `my_collection`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'TEA');");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 1, 'English Tea #1', 1, 28, 32, '2017.04.01', '02-08-3', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 1, 'Cinnamon Haze', 1, 28, 32, '2018.05.05', '02-08-4', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 1, 'Earl Grey', 1, 28, 32, '2002.01.07', '02-09-1', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 1, 'Earl Grey', 1, 28, 32, '2005.09.14', '02-09-2', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 1, 'Green Tea', 1, 28, 32, '2008.04.18', '02-09-4', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 1, 'English Breakfast', 1, 28, 32, '2001.04.05', '02-10-1', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 1, 'English Breakfast', 1, 28, 32, '1998.10.18', '02-10-2', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 1, 'Lemon & Lime Twist', 1, 28, 32, '2018.01.06', '02-10-3', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 1, 'Classic black tea', 1, 28, 32, '2013.05.20', '02-10-4', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'Yellow Label tea', 1, 28, 32, '2012.03.20', '02-11-2', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'Yellow Label tea', 1, 28, 32, '2005.03.20', '02-11-1', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'Royal Ceylon', 1, 28, 32, '2003.05.10', '02-11-3', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'A moment to energise', 1, 26, 28, '2017.12.31', '02-13-2', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'A moment to balance', 1, 26, 28, '2017.12.31', '02-13-3', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'pure black ceylon', 2, 22, 22, '2007.02.15', '01-17-1', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'cherry morello', 2, 22, 22, '2007.10.12', '01-17-2', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'pear chocolate', 2, 22, 22, '2007.08.29', '01-17-3', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'flirty lady', 2, 20, 20, '2015.07.14', '01-17-4', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'blue fruit', 2, 22, 22, '2011.03.20', '01-17-5', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'Orange Jaipur', 2, 22, 22, '2006.12.16', '01-18-3', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 11, 'temptation', 1, 23, 28, '2001.10.02', '01-14-1', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 10, 'finelly selected speciality tea', 2, 20, 28, '2003.05.16', '01-15-1', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 22, 'black', 2, 20, 28, '2000.12.28', '01-06-1', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 20, 'La via del te firenze', 2, 20, 28, '2005.09.12', '01-04-5', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 19, 'Cristmas tea', 1, 23, 28, '2017.12.25', '01-27-1', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 6, '100% pure ceylon tea', 1, 28, 32, '2003.11.12', '02-04-2', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 4, 'Black tea', 1, 28, 32, '2018.04.06', '02-01-1', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'Russian Earl Grey', 1, 25, 30, '2010.05.20', '02-12-4', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 2, 'English breakfast', 1, 28, 32, '2007.08.31', '02-19-4', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 2, 'flavoured tea', 1, 28, 32, '2011.05.10', '02-19-3', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 14, 'Lemon & Ginger', 1, 28, 32, '2015.10.18', '02-21-2', 1);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 8, '2006', 2, 20, 28, '2008.09.15', '01-02-4', 2);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 15, '1001 night', 2, 20, 28, '2010.04.20', '01-02-2', 2);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 16, 'Noir', 2, 23, 28, '2002.01.19', '01-04-2', 2);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 18, 'Zitrone', 1, 28, 32, '2009.02.14', '02-26-1', 2);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 12, 'Green tea bags', 2, 25, 28, '2010.11.05', '02-26-2', 2);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 23, 'green', 2, 20, 20, '2010.11.06', '01-03-3', 2);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 7, 'Ceylon gold', 2, 25, 30, '2010.04.09', '02-06-3', 2);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 7, 'Lychee', 2, 20, 28, '2012.03.22', '01-09-4', 2);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 7, 'Earl Grey', 2, 20, 28, '2012.01.19', '01-09-5', 2);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 7, 'Strawberry tea', 2, 20, 28, '2012.06.15', '01-09-2', 2);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 7, 'Natural green tea', 2, 20, 28, '2012.07.25', '01-09-1', 2);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 21, 'finest taste', 2, 25, 30, '2006.07.14', '01-16-1', 2);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 17, 'Exclusive smak natury', 2, 20, 28, '2016.12.15', '01-24-3', 2);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 5, 'history', 1, 28, 32, '2008.04.14', '02-35-1', 3);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 5, 'history', 1, 28, 32, '2008.04.14', '02-35-2', 3);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 5, 'history', 1, 28, 32, '2008.04.14', '02-35-3', 3);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 9, 'strawberry', 2, 25, 28, '2011.06.30', '02-39-3', 3);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 9, 'green tea', 1, 26, 28, '2010.03.25', '02-38-4', 3);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 9, 'black tea', 1, 28, 32, '2007.12.15', '02-38-3', 3);");
            statement.executeUpdate("INSERT INTO `my_collection`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 9, 'Have a nice tea time!', 1, 26, 28, '2010.05.04', '02-38-1', 3);");
        }
    }
}
