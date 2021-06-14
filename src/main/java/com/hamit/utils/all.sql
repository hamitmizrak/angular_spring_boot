CREATE SCHEMA `angular_springboot` DEFAULT CHARACTER SET utf8 ;

use angular_springboot;

select * from register where register_id=1;

insert register (register_name) values ("Deneme")

delete from register where register_id=4

UPDATE `angular_springboot`.`register` SET `register_name` = 'Deneme44' WHERE (`register_id` = '5');

update register set register_name="Deneme6666" where register_id=5