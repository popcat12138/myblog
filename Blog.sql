/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.18 : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `blog`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `blogId` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `Content` longtext,
  `blogType` varchar(30) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `AlterTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`blogId`),
  KEY `UserName1` (`UserName`),
  KEY `BlogType` (`blogType`),
  CONSTRAINT `BlogType` FOREIGN KEY (`blogType`) REFERENCES `blogtype` (`blogtype`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `UserName1` FOREIGN KEY (`UserName`) REFERENCES `users` (`UserName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `article` */

LOCK TABLES `article` WRITE;

insert  into `article`(`blogId`,`UserName`,`title`,`Content`,`blogType`,`createTime`,`AlterTime`) values (1,'张三','莫言：北京秋天下午的我 ','<p><strong>导语</strong></p>\r\n\r\n<p><em><strong><span style=\"font-family:SimSun\"><span style=\"font-size:16px\"><span style=\"background-color:#ecf0f1\">&nbsp; 我在北京生活这些年里，几乎没有感受到上个世纪里那些文人笔下的北京的秋天里美好的天。没有了那样的天，北京的秋天就仅仅是一个表现在日历牌上的季节，使生活在用空调制造出来的暧昧温度里、很少出门的人忘记了它。何时我们可以仰起头来，像满怀哲思的屈原或悠闲自在的陶潜一样望一望头上的天。</span></span></span></strong></em></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<hr />\r\n<p><strong><span style=\"font-size:16px\">&nbsp; &nbsp; &nbsp;</span><span style=\"font-size:18px\"> &nbsp;</span></strong></p>\r\n\r\n<p><strong><span style=\"font-size:18px\">&nbsp; &nbsp; &nbsp; &nbsp;据说北京的秋天最像秋天，但秋天的北京对于我却只是一大堆凌乱的印象。因为我很少出门，出门也多半是在居家周围的邮局、集市活动，或寄书，或买菜，目的明确，直奔目标而去，完成了就匆匆还家，沿途躲避着凶猛的车辆和各样的行人，几乎从来没有仰起头来，像满怀哲思的屈原或悠闲自在的陶潜一样望一望头上的天。</span></strong></p>\r\n\r\n<p><strong><span style=\"font-size:18px\">&nbsp; &nbsp; &nbsp; &nbsp;据说北京秋季的天是最蓝的，蓝得好似澄澈的海，如果天上有几朵白云，白云就像海上的白帆。如果再有一群白鸽在天上盘旋，鸽哨声声，欢快中蕴涵着几丝悲凉，天也就更像传说中的北京秋天的天了。但我在北京生活这些年里，几乎没有感受到上个世纪里那些文人笔下的北京的秋天里美好的天。没有了那样的天，北京的秋天就仅仅是一个表现在日历牌上的季节，使生活在用空调制造出来的暧昧温度里、很少出门的人忘记了它。</span></strong></p>\r\n\r\n<p><strong><span style=\"font-size:18px\">&nbsp; &nbsp; &nbsp; &nbsp;北京秋天的下午，我偶尔去菜市场采买。以前，北京的四季，不但可以从天空的颜色和植物的生态上分辨出来，而且还可以从市场上的蔬菜和水果上分辨出来。但现在的北京，由于交通的便捷和流通渠道的畅通，天南海北的水果一夜之间就可以跨洋越海地出现在市上。尤其是农业科技的进步，使季节对水果的生长失去了制约。比如从前，中秋节时西瓜已经很稀罕，而围着火炉吃西瓜更是一个梦想，但现在，即便是大雪飘飘的天气里，菜市场上，照样有西瓜卖。大冬天卖海南岛生产的西瓜不算稀奇，大冬天卖京郊农村塑料大棚里生产的西瓜也不算稀奇了。市上的水果蔬菜实在是丰富得让人眼花缭乱无所适从，东西多了，就没有好东西了。</span></strong></p>\r\n\r\n<p><strong><span style=\"font-size:18px\">&nbsp; &nbsp; &nbsp; 北京的秋天最为著名的地方就是香山，而香山的名气多半是因为那每到深秋就红遍了山坡的树叶。长红叶的树木多半是枫树。我猜想，当年曹雪芹曾经爬上过香山观赏过红叶，纳兰性德也上去过，许多达官贵人、社会名流也上去过。周作人在那附近的庙里住过很长时间，写出的文章里秋气弥漫，还有一股子树叶的苦涩味道。我在北京生活了近二十年，始终没去过香山。但似乎对那个地方并不陌生，那漫山遍野的红叶在我的脑海里存在着。如果真去了，肯定失望。我知道看红叶的人比红叶还要多，美景必须静观，热闹处无美景。</span></strong></p>\r\n\r\n<p><strong><span style=\"font-size:18px\">&nbsp; &nbsp; &nbsp; 现在是北京秋天的一个下午，我打破下午不写作的习惯，坐在书桌前，回忆着古人关于秋天的诗句来结束这篇文章：&ldquo;八月秋高风怒号，卷我屋上三重茅&rdquo;，&ldquo;秋风忽洒西园泪，满目山阳笛里人&rdquo;，&ldquo;枫叶纷纷落叶多，洞庭秋水晚来波&rdquo;&hellip;&hellip;古人有&ldquo;悲秋&rdquo;之说，大概是因为秋天的景象里昭示着繁华将逝，秋天的气候又暗示着寒冷将至，所以诗中的秋天总是有那么几分无可奈何的凄凉感。</span></strong></p>\r\n\r\n<p><strong><span style=\"font-size:18px\">&nbsp; &nbsp; &nbsp; 但也有唱反调的。李白就说：&ldquo;我觉秋兴逸，谁云秋兴悲&rdquo;；刘禹锡说：&ldquo;自古逢秋悲寂寥，我言秋日胜春朝&rdquo;；杜甫说：&ldquo;无边落木萧萧下，不尽长江滚滚来&rdquo;；黄巢说：&ldquo;待到秋来九月八，我花开放百花杀&rdquo;；毛泽东说：&ldquo;万木霜天红烂漫，天兵怒气冲霄汉&rdquo;。但即便是反调文章，也没有把悲变为喜，只不过是把悲凉化为悲壮而已。</span></strong></p>\r\n\r\n<p style=\"text-align:center\"><span style=\"font-family:SimHei\"><span style=\"font-size:14px\">文 / 莫言</span></span></p>\r\n','开心一刻','2021-11-21 21:48:11','2021-11-21 21:51:11'),(2,'张三','“滑蛋虾仁”好吃不难做','<p><strong><span style=\"font-size:20px\">&nbsp; &nbsp; &nbsp; &nbsp; &ldquo;滑蛋虾仁&rdquo;是一道健康又美味的粤菜，简单的原料，丰富的营养，亮丽的色彩，鲜嫩的口感，让这道家常菜非常受大家欢迎，其所含的营养的物质也灰常利于小孩子，老人吸收。 爽滑的蛋液包裹着鲜嫩的虾仁，但要把&ldquo;滑蛋虾仁&rdquo;的要做到鸡蛋滑嫩，虾仁爽脆，并不容易，关键在于一个&ldquo;滑&rdquo;字，自己在家如何能做好呢？</span></strong></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p style=\"text-align:center\"><span style=\"font-size:16px\"><span style=\"background-color:#ecf0f1\">掌握下面几步，保证能做出堪比星级饭店师傅炒出的&ldquo;滑蛋虾仁&rdquo;来。</span></span></p>\r\n\r\n<p style=\"text-align:center\">&nbsp;</p>\r\n\r\n<ol>\r\n	<li><span style=\"font-size:22px\">首先是处理鲜虾，虾仁洗净去掉虾线后，用料酒、半个蛋清、少量盐、生粉和姜末腌制，这样经过上浆入味后再焯水，虾仁会饱满有弹性而且味道鲜美；</span></li>\r\n	<li><span style=\"font-size:22px\">当然焯水的时间不易过长，避免虾仁老了； 其次是准备蛋液，取出4个鸡蛋，加入盐等调味后搅打成蛋液；</span></li>\r\n	<li><span style=\"font-size:22px\">下入葱花细末，能有效提味；再加入按1小勺淀粉和2小勺的水调制的水淀粉，这就是能让鸡蛋蓬松爽滑的秘诀哦（因为滑蛋其实也是指水滑）；</span></li>\r\n	<li><span style=\"font-size:22px\">最后是炒虾仁鸡蛋液，先大火将锅烧热，放入油，转动锅，让油铺满锅底部；</span></li>\r\n	<li><span style=\"font-size:22px\">转为小火后再倒入混合的蛋液，等蛋液边缘开始逐渐凝固后，用木铲将鸡蛋向锅的中央轻轻的推和堆，而不是像平时炒鸡蛋一样将蛋液打散；</span></li>\r\n	<li><span style=\"font-size:22px\">让鸡蛋和虾仁在锅子中央慢慢烘熟，等到八九成熟的时候就可以关火了，利用余热使蛋液完全熟透，这种程度鸡蛋虾仁就刚刚正好。</span></li>\r\n	<li><span style=\"font-size:22px\">这样制作出来的&ldquo;滑蛋虾仁&rdquo;，鸡蛋蓬松、柔软、嫩滑，虾仁鲜嫩、清爽、利口，绝对是不可多得的美味，比起那星级饭店毫不逊色。</span></li>\r\n</ol>\r\n','开心一刻','2021-11-21 21:56:56','2021-11-21 21:57:25'),(3,'张三','日子过久了才发现，这4个生活小窍门很管用，可惜很多人不知道','<p><span style=\"font-size:18px\">&nbsp; &nbsp; &nbsp; <img alt=\"yes\" src=\"http://localhost:8080/Blog/tools/ckeditor/plugins/smiley/images/thumbs_up.png\" style=\"height:23px; width:23px\" title=\"yes\" />生活中，我们总会遇到许多的小细节烦恼，如厨房里的油污问题。不过，经过我们的多年生活经验，也可通过小窍门来解决烦恼。看似复杂的油污，也可省时省力地清理掉。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp; &nbsp;小编今儿就给姐妹们介绍4个非常不错的小窍门，让我们的生活变得更加的便利。日子过得越来越舒心，再也不用担忧厨房里的各类污垢问题了。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp; &nbsp; 很多主妇们喜欢使用轻巧的锅具，如不锈钢材质的。不过，这种材质也会出现油污沉淀的情况，平时大家会用钢丝球来用力刷洗。但效果几乎没有，而且还会有划痕，导致锅底容易留残渣。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp; 该怎么处理呢？可以使用小妙招苏打粉来解决。把锅底冲洗一次，多余的灰尘给清理，撒上小苏打粉，再用湿润抹布盖在上面。隔天再清理，就会简单很多。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp; 是不是看着都麻烦呢？那我们也可以直接使用不锈钢清洁膏试试。只需要沾水在上面，再用膏体涂抹，然后就可用抹布擦洗掉了。在涂抹上去的时候，温和清理成分会逐步的溶解沉淀的油污。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp; 而且用途很广泛，除了不锈钢锅具、像灶台、墙壁、油烟机、地板、瓷砖、玻璃、五金器材等地方有顽固的污垢，都可以轻松去除，效果立竿见影，省时又省力。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;很多上班族会购买大量的肉品在家里，但平时吃的时候，解冻却成大问题。尤其是中午做菜，又要赶时间，肉品根本没法解冻，该怎么处理呢？</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;我们不妨使用不锈钢盆来解决，直接把冻肉拿出后，放在不锈钢盆里，然后上面再用一个不锈钢盆装水压在上面去。大约在5-10分就可解冻了。不锈钢导热好，可加速冻肉中的冰块融化。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;做饭菜的时候，我们会洗菜，看到水槽心里会作何感想呢？会不会太脏了，黑乎乎的一圈，玻璃胶上全是霉菌。这种霉菌主妇们一般使用抹布擦洗，但没有效果。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;该怎么办呢？可以用84消毒液来清理掉，直接把液体涂抹在上面，然后静置一晚上。隔天的时候，再用牙膏来清理，便可很快刷洗掉。不过84消毒液的腐蚀性强，大家要注意手部肌肤。<img alt=\"indecision\" src=\"http://localhost:8080/Blog/tools/ckeditor/plugins/smiley/images/whatchutalkingabout_smile.png\" style=\"height:23px; width:23px\" title=\"indecision\" /></span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;若是不想使用腐蚀性强的，那我们可以换成除霉啫喱。温和配方，采用纯植物提取，安全又环保。只需要涂抹在顽固霉菌的地方，便可轻松溶解霉菌，霉斑点。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp; 更值得一提的，它的用途非常广泛，除了水槽边，灶台边、水槽边、马桶底座、冰箱密封条、墙壁、墙纸、衣柜等等地方发霉了，都可以用它来去除霉斑，效果立竿见影。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp; 厨房是小，但平时走来走去，加上做饭的时候油污严重。很容易就导致地面产生油污沉淀，每次我们做完饭菜之后，就会感觉脚步踩上去黏糊黏糊的。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp; 清水清理很难处理掉油污，那不妨使用白醋+洗洁精+食盐来解决。直接喷洒在地面上，然后静置半个小时，就可以拖干净了。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp; 如果觉得非常麻烦，那我们不如使用这款可以为大家省钱，又能长久使用的静电拖把！<img alt=\"cool\" src=\"http://localhost:8080/Blog/tools/ckeditor/plugins/smiley/images/shades_smile.png\" style=\"height:23px; width:23px\" title=\"cool\" /></span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp; 这东西看上去跟普通拖把长得有些不一样，主要是看起来不怎么像是很好用的样子，实际上用过以后才发现，这个拖把对于头发和小尘土有着极强的杀伤力，非常好用！</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp; &nbsp;我家有了这个再也不用棉布拖把了！平时家务活干起来也更省心，特别是我们家里有喵主子的存在，掉毛那是不用说的事情，搬新家之后用上静电除尘拖把，对主子的烦恼都少了不少呢！</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp; 每天用它走一圈，用不了几分钟地上的污渍、灰尘和毛发都能沾上，非常轻松，连购买吸尘吸的钱都省了。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;厨房、卧室、客厅、阳台、柜台甚至玻璃窗户都可以清洁到位，为我们的生活带来极大的便捷。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;说起我们日常拖地，最常见的就是棉布条拖把和海绵拖把了。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;除了不好控制湿度，拖起来到处都湿嗒嗒的，还有拖到一半的时候就要拿去清洗，不然就会出现把脏水从一个地方拖到另外一个地方，简直就是&ldquo;无效清洁&rdquo;。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;而这款拖把，可以配两种&ldquo;拖布&rdquo;，一次性静电除尘干巾和一次性除菌湿巾。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;别看它是一次性的&ldquo;拖布&rdquo;，可用起来可一点也不鸡肋，尤其在清洁方面它们可谓最大功臣。<img alt=\"heart\" src=\"http://localhost:8080/Blog/tools/ckeditor/plugins/smiley/images/heart.png\" style=\"height:23px; width:23px\" title=\"heart\" /></span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;这款除菌湿巾首先拖布面积大，200*300mm的尺寸基本可以满足日常清洁。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;并且湿巾的含水量非常高，轻轻一挤就会出水，不会拖几个来回就拖不干净了。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;满足一般家庭客厅、卧室地面清洁的需求，脚印、水渍、油渍等都可以轻松擦除。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;不仅如此，湿巾还添加了三种杀菌成分，对于常见的大肠杆菌、金黄色葡萄球菌、白色念珠菌起到很好的抑制效果。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;平时家里的宝宝喜欢在地上爬、乱跑，家长就可以定期对地面进行清洁除菌，省心又省力。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;除菌湿巾由无纺布制成，厚度适中、柔软有韧性，不只是用来拖地，日常还可以代替传统抹布单独使用，擦桌子、柜子、灶台等等。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;除尘静电干巾：除尘静电干巾可以把灰尘、毛发迅速吸附在纸巾上，对于有宠物的家庭来说真的太方便了。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;并且在拖地的时候，灰尘、毛发也不会到处飞、随风飘，全都被吸附在干巾上。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;尤其是卧室、卫生间头发泛滥的地方，有了这款干巾再也不需要动手去捡，再也没有毛发缠在拖把、扫把上的烦恼！</span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;平时还可以先用干巾除尘，然后再使用湿巾来清洁，大大增强清洁效果。<img alt=\"devil\" src=\"http://localhost:8080/Blog/tools/ckeditor/plugins/smiley/images/devil_smile.png\" style=\"height:23px; width:23px\" title=\"devil\" /></span></p>\r\n\r\n<p><span style=\"font-size:18px\">&nbsp; &nbsp;拖一次地，相当于把吸尘、扫地、拖地、杀菌全部做了一遍，后续直接把用过的&ldquo;拖布&rdquo;直接丢进垃圾桶，清洁省时又省力！</span></p>\r\n','开心一刻','2021-11-21 22:03:40','2021-11-21 22:03:40'),(4,'刘刘','开心！','<p><span style=\"font-size:18px\">&nbsp; &nbsp; &nbsp; &nbsp;了解清楚今天是个好日子到底是一种怎么样的存在，是解决一切问题的关键。 现在，解决今天是个好日子的问题，是非常非常重要的。 所以， 既然如何。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">　　那么， 德国曾经说过，只有在人群中间，才能认识自己。这似乎解答了我的疑惑. 了解清楚今天是个好日子到底是一种怎么样的存在，是解决一切问题的关键。 今天是个好日子，发生了会如何，不发生又会如何。 今天是个好日子，到底应该如何实现。</span></p>\r\n\r\n<p><span style=\"font-size:18px\">　　就我个人来说，今天是个好日子对我的意义，不能不说非常重大。 现在，解决今天是个好日子的问题，是非常非常重要的。 所以， 拿破仑&middot;希尔在不经意间这样说过，不要等待，时机永远不会恰到好处。我希望诸位也能好好地体会这句话. 我们不得不面对一个非常尴尬的事实，那就是， 所谓今天是个好日子，关键是今天是个好日子需要如何写。 对我个人而言，今天是个好日子不仅仅是一个重大的事件，还可能会改变我的人生。 爱迪生说过一句富有哲理的话，失败也是我需要的，它和成功对我一样有价值。这似乎解答了我的疑惑. 所谓今天是个好日子，关键是今天是个好日子需要如何写。 今天是个好日子，到底应该如何实现。 从这个角度来看， 一般来讲，我们都必须务必慎重的考虑考虑。 米歇潘说过一句著名的话，生命是一条艰险的峡谷，只有勇敢的人才能通过。这句话把我们带到了一个新的维度去思考这个问题: 而这些并不是完全重要，更加重要的问题是， 今天是个好日子，发生了会如何，不发生又会如何。 从这个角度来看， 现在，解决今天是个好日子的问题，是非常非常重要的。 所以， 一般来说， 今天是个好日子因何而发生？ 从这个角度来看， 了解清楚今天是个好日子到底是一种怎么样的存在，是解决一切问题的关键。 所谓今天是个好日子，关键是今天是个好日子需要如何写。 那么， 一般来说， 既然如何， 今天是个好日子，发生了会如何，不发生又会如何。 一般来说， 而这些并不是完全重要，更加重要的问题是， 既然如此， 既然如何， 我们不得不面对一个非常尴尬的事实，那就是， 可是，即使是这样，今天是个好日子的出现仍然代表了一定的意义。 我们一般认为，抓住了问题的关键，其他一切则会迎刃而解。 就我个人来说，今天是个好日子对我的意义，不能不说非常重大。 那么， 今天是个好日子的发生，到底需要如何做到，不今天是个好日子的发生，又会如何产生。 我们不得不面对一个非常尴尬的事实，那就是， 带着这些问题，我们来审视一下今天是个好日子。<img alt=\"yes\" src=\"http://localhost:8080/Blog/tools/ckeditor/plugins/smiley/images/thumbs_up.png\" style=\"height:23px; width:23px\" title=\"yes\" /></span></p>\r\n','好日子！','2021-11-21 22:22:41','2021-11-21 22:22:41'),(5,'刘刘','今天捡了一毛钱','<p><em><span style=\"font-size:16px\">屠格涅夫说过一句富有哲理的话，你想成为幸福的人吗？但愿你首先学会吃得起苦。带着这句话, 我们还要更加慎重的审视这个问题: 今天捡了一毛钱因何而发生？ 马云曾经提到过，最大的挑战和突破在于用人，而用人最大的突破在于信任人。这似乎解答了我的疑惑. 我们不得不面对一个非常尴尬的事实，那就是， 鲁巴金在不经意间这样说过，读书是在别人思想的帮助下，建立起自己的思想。带着这句话, 我们还要更加慎重的审视这个问题: 达尔文曾经提到过，敢于浪费哪怕一个钟头时间的人，说明他还不懂得珍惜生命的全部价值。这不禁令我深思. 老子在不经意间这样说过，知人者智，自知者明。胜人者有力，自胜者强。</span></em></p>\r\n\r\n<p><em><span style=\"font-size:16px\">这不禁令我深思. 那么， 那么， 我们不得不面对一个非常尴尬的事实，那就是， 既然如此， 带着这些问题，我们来审视一下今天捡了一毛钱。 我认为， 所谓今天捡了一毛钱，关键是今天捡了一毛钱需要如何写。 今天捡了一毛钱，发生了会如何，不发生又会如何。 了解清楚今天捡了一毛钱到底是一种怎么样的存在，是解决一切问题的关键。 我认为， 就我个人来说，今天捡了一毛钱对我的意义，不能不说非常重大。 本人也是经过了深思熟虑，在每个日日夜夜思考这个问题。 今天捡了一毛钱因何而发生？ 我们都知道，只要有意义，那么就必须慎重考虑。 我们不得不面对一个非常尴尬的事实，那就是， 今天捡了一毛钱，到底应该如何实现。 可是，即使是这样，今天捡了一毛钱的出现仍然代表了一定的意义。<img alt=\"crying\" src=\"http://localhost:8080/Blog/tools/ckeditor/plugins/smiley/images/cry_smile.png\" style=\"height:23px; width:23px\" title=\"crying\" /></span></em></p>\r\n\r\n<p><em><span style=\"font-size:16px\">我们不得不面对一个非常尴尬的事实，那就是， 那么， 从这个角度来看， 一般来讲，我们都必须务必慎重的考虑考虑。 这样看来， 总结的来说， 今天捡了一毛钱，发生了会如何，不发生又会如何。 今天捡了一毛钱，发生了会如何，不发生又会如何。 海贝尔说过一句著名的话，人生就是学校。在那里，与其说好的教师是幸福，不如说好的教师是不幸。这不禁令我深思. 别林斯基在不经意间这样说过，好的书籍是最贵重的珍宝。带着这句话, 我们还要更加慎重的审视这个问题: 一般来讲，我们都必须务必慎重的考虑考虑。 爱迪生说过一句著名的话，失败也是我需要的，它和成功对我一样有价值。这不禁令我深思. 苏轼说过一句富有哲理的话，古之立大事者，不惟有超世之才，亦必有坚忍不拔之志。这句话语虽然很短, 但令我浮想联翩. 今天捡了一毛钱，发生了会如何，不发生又会如何。<img alt=\"wink\" src=\"http://localhost:8080/Blog/tools/ckeditor/plugins/smiley/images/wink_smile.png\" style=\"height:23px; width:23px\" title=\"wink\" /></span></em></p>\r\n\r\n<p><em><span style=\"font-size:16px\">　　所谓今天捡了一毛钱，关键是今天捡了一毛钱需要如何写。 那么， 池田大作曾经说过，不要回避苦恼和困难，挺起身来向它挑战，进而克服它。带着这句话, 我们还要更加慎重的审视这个问题: 了解清楚今天捡了一毛钱到底是一种怎么样的存在，是解决一切问题的关键。 每个人都不得不面对这些问题。 在面对这种问题时， 培根曾经说过，深窥自己的心，而后发觉一切的奇迹在你自己。这似乎解答了我的疑惑. 今天捡了一毛钱，到底应该如何实现。<img alt=\"angry\" src=\"http://localhost:8080/Blog/tools/ckeditor/plugins/smiley/images/angry_smile.png\" style=\"height:23px; width:23px\" title=\"angry\" /> </span></em></p>\r\n\r\n<p><em><span style=\"font-size:16px\">今天捡了一毛钱，发生了会如何，不发生又会如何。 本人也是经过了深思熟虑，在每个日日夜夜思考这个问题。 富勒曾经说过，苦难磨炼一些人，也毁灭另一些人。带着这句话, 我们还要更加慎重的审视这个问题: 今天捡了一毛钱，到底应该如何实现。 而这些并不是完全重要，更加重要的问题是， 一般来讲，我们都必须务必慎重的考虑考虑。 这种事实对本人来说意义重大，相信对这个世界也是有一定意义的。 我们不得不面对一个非常尴尬的事实，那就是， 今天捡了一毛钱，到底应该如何实现。 屠格涅夫说过一句富有哲理的话，你想成为幸福的人吗？但愿你首先学会吃得起苦。这句话把我们带到了一个新的维度去思考这个问题: 黑格尔说过一句富有哲理的话，只有永远躺在泥坑里的人，才不会再掉进坑里。这句话把我们带到了一个新的维度去思考这个问题。<img alt=\"heart\" src=\"http://localhost:8080/Blog/tools/ckeditor/plugins/smiley/images/heart.png\" style=\"height:23px; width:23px\" title=\"heart\" /></span></em></p>\r\n','啦啦啦啦','2021-11-21 22:26:06','2021-11-21 22:26:06'),(6,'高宇','“地质人员云南哀牢山失联”搜救三问：新线索？存在困难？投入设备？','<p>&nbsp;</p>\r\n\r\n<p><u><span style=\"font-size:16px\"><span style=\"background-color:#ecf0f1\">&ldquo;地质人员云南哀牢山失联&rdquo;事件进入第8天，公安、消防及专业救援队等各种救援力量已连日在普洱市、玉溪市、楚雄州三地开展搜救。何处发现新线索？存在哪些困难？投入了哪些现代设备？记者围绕公众关注的诸多问题开展了采访。</span></span></u></p>\r\n\r\n<p style=\"text-align:center\"><span style=\"font-size:16px\"><strong>在何处发现新线索？</strong></span></p>\r\n\r\n<p><span style=\"font-size:16px\">&nbsp; &nbsp; 20日，救援人员在云南普洱市镇沅县者东镇的白水河附近两条小溪交汇处，发现失联人员的一件雨衣和一些排泄物。正在现场参与救援的普洱市森林消防支队政委刘东君说：&ldquo;前往新发现失联人员物品的区域山地徒步需要数小时，该处有一个较大的深沟，救援人员携带有攀爬工具等设备，将重点在深沟开展搜索。&rdquo;</span></p>\r\n\r\n<p><span style=\"font-size:16px\">&nbsp; &nbsp; 11月13日，中国地质调查局昆明自然资源综合调查中心4名工作人员，从云南省普洱市镇沅县者东镇进入哀牢山山区开展野外作业失联，当地接报后紧急成立失联人员救援指挥部，组织开展搜索救援。</span></p>\r\n\r\n<p><span style=\"font-size:16px\">&nbsp; &nbsp; 据云南省消防救援总队副总队长王岗介绍，截至21日，搜救区域确定为&ldquo;三区一线&rdquo;：哀牢山普洱市镇沅县一侧片区、哀牢山玉溪市新平县一侧片区、楚雄州双柏县一侧片区和哀牢山山脊线。</span></p>\r\n\r\n<p><span style=\"font-size:16px\">&nbsp; &nbsp;&ldquo;分别以山脊为线，沿哀牢山西南、东北、正北3个方向搜救，救援行动由划片循迹搜索转为地毯式重点搜索，搜救方式由独立搜索转为3个区域相向合围。&rdquo;王岗说。</span></p>\r\n\r\n<p><span style=\"font-size:16px\">&nbsp; &nbsp; &nbsp;在镇沅一侧，镇沅县常务副县长、搜救指挥部常务副指挥长张兆辉介绍，由3支携带补给、露营装备的重装穿越组，向新平一侧开展纵深搜索；14个搜救组围绕失联人员活动过的区域，扩大到半径3公里的范围内进行拉网式、地毯式精准搜救。21日参与救援人数共724人，已累计出动救援人员2650余人次。</span></p>\r\n\r\n<p><span style=\"font-size:16px\">&nbsp; &nbsp; 在玉溪一侧，4支由向导、消防救援、森林消防、扑火队等专业搜救和具有野外生存经验人员组成的救援队，按照&ldquo;地毯式搜索&rdquo;的方式开展救援。截至21日，玉溪市已累计投入1100余人次开展救援。</span></p>\r\n\r\n<p style=\"text-align:center\"><span style=\"font-size:16px\"><strong>搜救工作存在哪些困难？</strong></span></p>\r\n\r\n<p><span style=\"font-size:16px\">&nbsp; &nbsp; 哀牢山位于云南中部，是云贵高原和横断山脉的分界线，也是全国最大的原始常绿阔叶林区，最高海拔3156米。失联人员位处的区域是哀牢山国家级自然保护区，平均海拔2500米以上。搜救工作目前存在三方面主要困难：</span></p>\r\n\r\n<p><span style=\"font-size:16px\">&nbsp; &nbsp; &nbsp; 第一，哀牢山在镇沅境内面积达13.5万亩，此次人员失联的区域，地处哀牢山国家级自然保护区的核心区域，属原始森林无人区，山陡林密、遍布山崖和沟壑，地形极其复杂。</span></p>\r\n\r\n<p><span style=\"font-size:16px\">&nbsp; &nbsp; &nbsp;第二，正值入冬天气，昼夜温差较大，白天能达到20度左右，到了晚上则降到七八度，山区树木高大茂密，加之近期连日降雨，林中有雾，能见度极低。</span></p>\r\n\r\n<p><span style=\"font-size:16px\">&nbsp; &nbsp; 第三，搜救路线距离较远，从山脚前往搜索区域需要爬山约4个小时，随着搜索范围不断扩大，山中无路，行进困难，不具备夜间搜索的条件，队员往返宿地耗时较长。</span></p>\r\n\r\n<p><span style=\"font-size:16px\">&nbsp; &nbsp; 张兆辉介绍，针对这些情况，救援指挥部在山头建立了多个补给站，搭建简易棚舍，搜救人员可利用睡袋在山上过夜，并采用直升机空投方式补给，提高搜救效率，全力以赴开展救援。</span></p>\r\n\r\n<p><span style=\"font-size:16px\">&ldquo;我们不放过任何一个沟壑、岩洞以及每一个存疑区域，只要有一线希望，就竭尽全力开展搜救。&rdquo;杨磊说。</span></p>\r\n\r\n<p style=\"text-align:center\"><span style=\"font-size:16px\"><strong>投入了哪些设备？</strong></span></p>\r\n\r\n<p><span style=\"font-size:16px\">&nbsp; &nbsp; &nbsp;正在现场救援的云南省消防救援总队战训处副处长杨磊介绍，携带热成像相机的无人机、搜救犬已投入搜救工作。</span></p>\r\n\r\n<p><span style=\"font-size:16px\">&nbsp; &nbsp; &ldquo;在悬崖、沟壑等区域，救援人员放飞热成像无人机进行环绕拍摄，搜索热源线索，但是由于森林极为茂密，无人机在空中无法拍摄到林下的影像，效果有限。&rdquo;杨磊说。</span></p>\r\n\r\n<p><span style=\"font-size:16px\">&nbsp; &nbsp; &nbsp;同时，消防救援队投入了5条搜救犬，先把已找到的失联人员物品给搜救犬作为嗅源，再由训导员牵引在重点区域开展搜索。&ldquo;范围太大，搜救犬要在十几平方公里的范围内工作，和传统的平地搜索、废墟搜索完全不同。&rdquo;杨磊说。</span></p>\r\n\r\n<p><span style=\"font-size:16px\">&nbsp; &nbsp;张兆辉说，连日来，直升机在重点区域飞行进行喊话和搜索，但未发现有用线索，也未收到诸如烟火、求救图案等反馈。&ldquo;丛林搜救非常特殊，人力搜救仍是主要手段。&rdquo;张兆辉说。</span></p>\r\n\r\n<p><span style=\"font-size:16px\">&nbsp; &nbsp; 在通讯保障方面，张兆辉介绍，一架携带空中通讯基站的&ldquo;玉龙&rdquo;无人机21日抵达镇沅县，当日开展飞行作业。中国移动云南公司已向镇沅、新平、双柏三地增派应急卫星通讯车。</span></p>\r\n','时政新闻','2021-11-21 22:32:32','2021-11-21 22:32:32'),(7,'高宇','啦啦啦','<p><img alt=\"yes\" src=\"http://localhost:8080/Blog/tools/ckeditor/plugins/smiley/images/thumbs_up.png\" style=\"height:23px; width:23px\" title=\"yes\" /></p>\r\n\r\n<p><span style=\"font-family:SimSun\"><span style=\"font-size:18px\">必须顶<br />\r\n不得不顶<br />\r\n用尽全力顶<br />\r\n再加上千斤顶<br />\r\n总之把它顶到顶<br />\r\n接着使出葵花宝顶<br />\r\n就算顶到史前也要顶<br />\r\n老子看了会用道德经顶<br />\r\n孔子亲自拜你为师天天顶<br />\r\n秦始皇站在阿房宫上使劲顶<br />\r\n汉高祖挥师杀向东罗马为你顶<br />\r\n吕布抛弃了貂禅而选择了帮你顶<br />\r\n张三丰见了后用太极拳九式全力顶<br />\r\n左冷禅召开武林盟主大会商讨如何顶<br />\r\n西门吹雪从此学会了最强一招剑神一顶<br />\r\n龙剑飞的如来神掌最后一式改为万佛朝顶<br />\r\n陆小凤从此再也不管闲事了而专门来为你顶<br />\r\n四大名捕四面出击看天下还有没有人敢不再顶</span></span></p>\r\n','小小故事','2021-11-21 22:38:00','2021-11-21 22:38:24'),(8,'悟空','齐天大圣孙悟空','<p style=\"text-align:center\"><em><span style=\"font-family:SimSun\"><span style=\"font-size:18px\"><span style=\"background-color:#ecf0f1\">试问，你喜欢孙悟空吗？</span></span></span></em></p>\r\n\r\n<p style=\"text-align:center\"><em><span style=\"font-family:SimSun\"><span style=\"font-size:18px\"><span style=\"background-color:#ecf0f1\">那么，你对孙悟空的了解有多少呢？</span></span></span></em></p>\r\n\r\n<p><em><span style=\"font-family:SimSun\"><span style=\"font-size:18px\"><span style=\"background-color:#ecf0f1\">&nbsp; &nbsp;对他之了解停留在了大闹天宫或者三打白骨精之上？除此之外，还能有别的认识吗？大家都知道他是从石头里蹦出来的大胖小子，一出生便能走能爬，又一跃进了水帘洞称大王，跑去方寸山拜了个菩提祖师，学来法术，往龙宫抢夺兵器，往地府划去生死簿上名字。</span></span></span></em></p>\r\n\r\n<p><em><span style=\"font-family:SimSun\"><span style=\"font-size:18px\"><span style=\"background-color:#ecf0f1\">&nbsp; &nbsp;了解以上，皆只是略懂皮毛，大家可曾研究过他的台词？他的口头禅，你懂吗？</span></span></span></em></p>\r\n\r\n<p><em><span style=\"font-family:SimSun\"><span style=\"font-size:18px\"><span style=\"background-color:#ecf0f1\">&nbsp; &nbsp;有话说：文如其人。其实，你的说话方式与说话内容，正正决定了你的性格！甚至还能左右你今后的人生，从这，能看出十年或数十年后，能否成就一个大才。</span></span></span></em></p>\r\n\r\n<p><em><span style=\"font-family:SimSun\"><span style=\"font-size:18px\"><span style=\"background-color:#ecf0f1\">&nbsp; &nbsp;孙悟空的口头禅决定了他是一只性情暴躁却又嫉恶如仇的猴。</span></span></span></em></p>\r\n\r\n<p><em><span style=\"font-family:SimSun\"><span style=\"font-size:18px\"><span style=\"background-color:#ecf0f1\">&nbsp; &nbsp;你去乾坤四海问一问，我是历代驰名第一妖！</span></span></span></em></p>\r\n\r\n<p><em><span style=\"font-family:SimSun\"><span style=\"font-size:18px\"><span style=\"background-color:#ecf0f1\">&nbsp; &nbsp;乾坤四海，其实应有五湖四海之意，可解释为，你去打听打听，西游三界内，我何不是最牛的一只妖怪？这句话的后半句，他用了&ldquo;历代驰名&rdquo;，称&ldquo;第一&rdquo;便罢了，还要加上&ldquo;历代驰名&rdquo;，足以可见他这人十分骄傲，甚不低调。</span></span></span></em></p>\r\n\r\n<p><em><span style=\"font-family:SimSun\"><span style=\"font-size:18px\"><span style=\"background-color:#ecf0f1\">&nbsp; &nbsp;皇帝轮流做，明年到我家。</span></span></span></em></p>\r\n\r\n<p><em><span style=\"font-family:SimSun\"><span style=\"font-size:18px\"><span style=\"background-color:#ecf0f1\">&nbsp; &nbsp;此话当乃惊世骇俗之语！在天庭，当着众天兵天将的面，可能他的眼睛还瞅着玉帝凌霄宝殿的那个方位，便大喊道&ldquo;皇帝轮流做，明年到我家&rdquo;，常人见到玉帝把头缩进了裤腰带了，恐惧到即便过背在心里都不敢说玉帝坏话，如今孙悟空竟敢当面出言不逊，可真够放肆。</span></span></span></em></p>\r\n\r\n<p><em><span style=\"font-family:SimSun\"><span style=\"font-size:18px\"><span style=\"background-color:#ecf0f1\">&nbsp; 这些都出自孙悟空之口，但不是经典的，更不是最经典的。</span></span></span></em></p>\r\n\r\n<p><em><span style=\"font-family:SimSun\"><span style=\"font-size:18px\"><span style=\"background-color:#ecf0f1\">&nbsp; 每当他打妖怪时，这些经典语录就来了。瞧着啊。</span></span></span></em></p>\r\n\r\n<p><em><span style=\"font-family:SimSun\"><span style=\"font-size:18px\"><span style=\"background-color:#ecf0f1\">&nbsp; 取经路上妖怪众多，白骨精、蝎子精、老鼠精、玉兔精、蟒蛇精、狐狸精等等，不论是这些美若天仙或胜过天仙的女妖，还是那些粗鲁蛮横的男妖，孙悟空在打死他们之前，嘴里都要大声喊叫道：吃俺老孙一棒！</span></span></span></em></p>\r\n\r\n<p><em><span style=\"font-family:SimSun\"><span style=\"font-size:18px\"><span style=\"background-color:#ecf0f1\">&nbsp; 这是口头禅，更是口号。士兵上战场杀敌，都要大声呼喊自己的口号的，一来长自己士气，二来灭他们威风，口号与心理有极大关系，口号声越大，其能在心理战斗上战胜敌人，对战争的胜利起到了非常重大的作用。而孙悟空的这句口头禅，正有此意。</span></span></span></em></p>\r\n\r\n<p><em><span style=\"font-family:SimSun\"><span style=\"font-size:18px\"><span style=\"background-color:#ecf0f1\">&nbsp; 有的小妖小怪，如狐狸精这般，还未遭受金箍棒一击打，听到孙悟空这句话，腿便酸了，魂便丢了，战战兢兢不能起身，瘫软在地了。</span></span></span></em></p>\r\n\r\n<p><em><span style=\"font-family:SimSun\"><span style=\"font-size:18px\"><span style=\"background-color:#ecf0f1\">&nbsp; &nbsp;而时代更迭，孙悟空的这句经典口头禅却发生了极为大的改变！它不再是打妖除魔的正义语录了，不再带有严肃的气韵，而是一股戏谑，常应用在男人之间。比如说，一群发小，多年后聚会，定是欢笑不已，激动不已，此时此刻，是要跑去网吧上个通宵，使劲开黑，用力欢笑，许久不见，还是要一连上好几个通宵，开好多把黑，彻底放纵，夜夜往他身上捶打呼嚎：吃俺老孙一棒！小子，多年未见，死哪儿去了？</span></span></span></em></p>\r\n\r\n<p><em><span style=\"font-family:SimSun\"><span style=\"font-size:18px\"><span style=\"background-color:#ecf0f1\">&nbsp; 打得越重，叫得越欢，感情越深！损友、基友，一辈子，好朋友。</span></span></span></em></p>\r\n','火眼金睛','2021-11-22 12:04:31','2021-11-22 12:04:31');

UNLOCK TABLES;

/*Table structure for table `blogtype` */

DROP TABLE IF EXISTS `blogtype`;

CREATE TABLE `blogtype` (
  `UserName` varchar(50) NOT NULL,
  `blogtype` varchar(30) NOT NULL,
  PRIMARY KEY (`UserName`,`blogtype`),
  KEY `blogtype` (`blogtype`),
  CONSTRAINT `UserName` FOREIGN KEY (`UserName`) REFERENCES `users` (`UserName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `blogtype` */

LOCK TABLES `blogtype` WRITE;

insert  into `blogtype`(`UserName`,`blogtype`) values ('刘刘','啦啦啦啦'),('刘刘','好日子！'),('高宇','小小故事'),('张三','开心一刻'),('张三','技术分享'),('高宇','时政新闻'),('悟空','火眼金睛'),('张三','生活小妙招');

UNLOCK TABLES;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `blogId` int(11) NOT NULL,
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(50) NOT NULL,
  `content` varchar(300) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `parentId` int(11) DEFAULT '-1',
  `UserNameB` varchar(50) NOT NULL,
  `state` varchar(10) NOT NULL DEFAULT '正常',
  PRIMARY KEY (`commentId`),
  KEY `UserName` (`UserName`),
  KEY `BlogId` (`blogId`),
  KEY `UserNameB` (`UserNameB`),
  CONSTRAINT `Comment_ibfk_1` FOREIGN KEY (`blogId`) REFERENCES `article` (`blogId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Comment_ibfk_2` FOREIGN KEY (`UserName`) REFERENCES `users` (`UserName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Comment_ibfk_3` FOREIGN KEY (`UserNameB`) REFERENCES `users` (`UserName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_chk_1` CHECK (((`state` = _utf8mb3'正常') or (`state` = _utf8mb3'禁用')))
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

LOCK TABLES `comment` WRITE;

insert  into `comment`(`blogId`,`commentId`,`UserName`,`content`,`createTime`,`parentId`,`UserNameB`,`state`) values (1,1,'张三','北京冬天傍晚的我','2021-11-21 21:52:18',-1,'张三','正常'),(2,2,'张三','好耶!','2021-11-21 21:57:42',-1,'张三','正常'),(1,3,'刘刘','楼主好文采！','2021-11-21 22:16:18',-1,'张三','正常'),(1,4,'刘刘','北京夏天凌晨的我','2021-11-21 22:17:08',1,'张三','正常'),(6,5,'高宇','希望一切平安','2021-11-21 22:33:21',-1,'高宇','正常'),(1,6,'高宇','北京春天中午的我','2021-11-21 22:34:29',1,'刘刘','正常'),(1,7,'高宇','楼主写的不错！啊怀念','2021-11-21 22:35:01',-1,'张三','正常'),(1,8,'高宇','破坏楼层','2021-11-21 22:35:37',1,'张三','正常'),(7,9,'高宇','水经验','2021-11-21 22:38:43',-1,'高宇','正常'),(5,10,'高宇','什么玩意？','2021-11-21 23:18:22',-1,'刘刘','正常'),(3,11,'悟空','营销号找打！','2021-11-22 12:05:14',-1,'张三','正常');

UNLOCK TABLES;

/*Table structure for table `log` */

DROP TABLE IF EXISTS `log`;

CREATE TABLE `log` (
  `logId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `logContent` varchar(100) DEFAULT NULL,
  `logTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`logId`),
  KEY `userName` (`userName`),
  CONSTRAINT `Log_ibfk_1` FOREIGN KEY (`userName`) REFERENCES `users` (`UserName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `log` */

LOCK TABLES `log` WRITE;

insert  into `log`(`logId`,`userName`,`logContent`,`logTime`) values (1,'张三','注册成功','2021-11-21 21:41:18'),(2,'张三','登录成功','2021-11-21 21:41:28'),(3,'刘刘','注册成功','2021-11-21 22:15:41'),(4,'刘刘','登录成功','2021-11-21 22:15:50'),(5,'高宇','注册成功','2021-11-21 22:27:59'),(6,'高宇','登录成功','2021-11-21 22:28:07'),(7,'高宇','登录成功','2021-11-21 23:17:22'),(8,'高宇','登录成功','2021-11-22 11:38:11'),(9,'高宇','登录成功','2021-11-22 11:45:09'),(10,'高宇','登录成功','2021-11-22 11:56:20'),(11,'悟空','注册成功','2021-11-22 12:00:42'),(12,'悟空','登录成功','2021-11-22 12:00:54'),(13,'悟空','登录成功','2021-11-22 13:40:21'),(14,'高宇','登录成功','2021-11-22 13:41:12'),(15,'高宇','登录成功','2021-11-22 14:16:52'),(16,'高宇','登录成功','2021-11-22 14:20:37'),(17,'刘刘','禁用用户登录','2021-11-22 14:21:31'),(18,'高宇','登录成功','2021-11-22 14:21:43'),(19,'高宇','登录成功','2021-11-22 14:28:16'),(20,'张三','登录成功','2021-11-22 14:29:03');

UNLOCK TABLES;

/*Table structure for table `operlog` */

DROP TABLE IF EXISTS `operlog`;

CREATE TABLE `operlog` (
  `LogId` int(11) NOT NULL AUTO_INCREMENT,
  `operator` varchar(50) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `logContent` varchar(100) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`LogId`),
  KEY `operator` (`operator`),
  KEY `UserName` (`userName`),
  CONSTRAINT `OperLog_ibfk_1` FOREIGN KEY (`operator`) REFERENCES `users` (`UserName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `OperLog_ibfk_2` FOREIGN KEY (`userName`) REFERENCES `users` (`UserName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `operlog` */

LOCK TABLES `operlog` WRITE;

insert  into `operlog`(`LogId`,`operator`,`userName`,`logContent`,`createTime`) values (1,'高宇','张三','修改用户为管理员','2021-11-22 11:39:19'),(2,'高宇','张三','修改用户为普通用户','2021-11-22 11:39:21'),(3,'高宇','张三','修改用户状态为禁用','2021-11-22 11:39:22'),(4,'高宇','张三','修改用户状态为启用','2021-11-22 11:39:23'),(5,'高宇','张三','管理员修改密码','2021-11-22 11:45:51'),(6,'高宇','刘刘','修改信息','2021-11-22 11:56:51'),(7,'高宇','刘刘','修改用户为管理员','2021-11-22 11:58:26'),(8,'高宇','刘刘','修改用户为普通用户','2021-11-22 11:58:30'),(9,'高宇','刘刘','修改用户状态为禁用','2021-11-22 11:58:31'),(10,'高宇','刘刘','修改用户状态为启用','2021-11-22 11:58:34'),(11,'高宇','悟空','修改用户为管理员','2021-11-22 13:41:55'),(12,'高宇','刘刘','修改用户状态为禁用','2021-11-22 13:42:10'),(13,'高宇','刘刘','修改信息','2021-11-22 14:22:17'),(14,'高宇','高宇','修改信息','2021-11-22 14:23:22'),(15,'高宇','张三','修改信息','2021-11-22 14:23:37'),(16,'高宇','悟空','修改信息','2021-11-22 14:24:08'),(17,'高宇','张三','修改信息','2021-11-22 14:24:48'),(18,'高宇','张三','修改信息','2021-11-22 14:25:11'),(19,'高宇','张三','修改信息','2021-11-22 14:25:32');

UNLOCK TABLES;

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `UserName` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `fullName` varchar(50) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `birthday` date NOT NULL,
  `phoneNum` decimal(11,0) NOT NULL,
  `userEmail` varchar(70) NOT NULL,
  `weiXin` varchar(50) NOT NULL,
  `myWords` varchar(100) NOT NULL,
  `registerTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `alterTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `role` varchar(10) DEFAULT '普通用户',
  `state` varchar(10) DEFAULT '启用',
  `imgPath` varchar(200) DEFAULT 'img/default.jpeg',
  PRIMARY KEY (`UserName`),
  CONSTRAINT `users_chk_1` CHECK (((`sex` = _utf8mb3'男') or (`sex` = _utf8mb3'女'))),
  CONSTRAINT `users_chk_2` CHECK (((`role` = _utf8mb3'管理员') or (`role` = _utf8mb3'普通用户'))),
  CONSTRAINT `users_chk_3` CHECK (((`state` = _utf8mb3'启用') or (`state` = _utf8mb3'禁用')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

LOCK TABLES `users` WRITE;

insert  into `users`(`UserName`,`password`,`fullName`,`sex`,`birthday`,`phoneNum`,`userEmail`,`weiXin`,`myWords`,`registerTime`,`alterTime`,`role`,`state`,`imgPath`) values ('刘刘','12345678','丽丽','女','2000-01-21','12312312312','popcat12138@gmail.com','weixin123','今天是个好日子,心想的事儿都能成!明天又是好日子，千金的光阴不能等。！','2021-11-21 22:15:41','2021-11-22 14:22:17','普通用户','禁用','img/23d7397102f34f9abf71c59f904d8550_4f086e5bc6bec51783318471d0ae80ca.jpeg'),('张三','12345678','高宇','男','2001-01-02','18888888888','88888888@qq.com','weixin','子非我，安知我不知鱼之乐？','2021-11-21 21:41:18','2021-11-22 14:29:42','普通用户','启用','img/02da726b32e94eb096a1137e52471965_773d6ff73eddc3f523a1cf57d35b48a6.jpeg'),('悟空','12345678','火眼金睛','男','2000-01-01','13333333333','333@qq.com','高宇','老子是五百年前大闹天宫的孙悟空','2021-11-22 12:00:42','2021-11-22 14:24:07','管理员','启用','img/36b1064f359a43c5aee7f738b1b0d9c0_4f086e5bc6bec51783318471d0ae80ca.jpeg'),('高宇','12345678','高宇','男','2000-01-01','18888888888','popcat12138@gmail.com','lalalalala','子非我，安知我不知鱼之乐？','2021-11-21 22:27:59','2021-11-22 14:23:22','管理员','启用','img/a219f4d7997e4f6c99b56981ce8546d0_324cc4b4cb9c2ac3dfd80ff4541662b9.jpeg');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
