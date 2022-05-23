/*
 **********************************企业管理模块*************************************
 */

-- 证券市值，用户持有的理财产品金额
drop table if exists bk_customer_assets;
create table bk_customer_assets
(
    customerid    int(10) primary key auto_increment comment '主键',
    userid        int(10) comment '客户id',
    com_id        int(10) comment '企业id',
    holdnumber    int(10) comment '持有数量',
    holdmoney     float(10, 2) comment '成本价格',
    state          int(10) default 1 comment '状态' -- 0.删除  1.可用
);

insert into bk_customer_assets values (customerId,1,1,30,25.22,1);
insert into bk_customer_assets values (customerId,1,2,78,18.88,1);
insert into bk_customer_assets values (customerId,2,1,25,38.23,1);
insert into bk_customer_assets values (customerId,2,2,121,10.34,1);
insert into bk_customer_assets values (customerId,2,3,23,35.88,1);
insert into bk_customer_assets values (customerId,2,4,130,1.88,1);
insert into bk_customer_assets values (customerId,3,1,130,14.38,1);
insert into bk_customer_assets values (customerId,3,2,10,28.38,1);
insert into bk_customer_assets values (customerId,3,3,88,34.47,1);
insert into bk_customer_assets values (customerId,3,4,1,4.38,1);
insert into bk_customer_assets values (customerId,3,5,15,7.38,1);
insert into bk_customer_assets values (customerId,3,6,53,14.55,1);
insert into bk_customer_assets values (customerId,4,1,33,10.55,1);
insert into bk_customer_assets values (customerId,4,4,11,15.55,1);
insert into bk_customer_assets values (customerId,5,1,143,8.05,1);

-- 充值提现管理
drop table if exists bk_invest_money;
CREATE table bk_invest_money
(
    investmoneyid     int(10) primary key auto_increment comment '主键',
    userid             int(10) comment '客户id',
    userName           varchar(20) comment '客户名称',
    userCode           varchar(20) ,
    investmoneytype   int(10) comment '交易类型',
    investmoney        float(10, 2) comment '交易金额',
    investrequesttime timestamp comment '请求时间',
    investhandletime  timestamp comment '处理时间',
    investbankcode    int(10) comment '银行代码',
    investstate        int(10) comment '汇款状态',
    -- 2:已汇款到用户
    state               int(10) default 1 comment '状态' -- 0.删除  1.可用
);
insert into bk_invest_money values(investmoneyid,?,?,?,?,?,?,?,?,?,1);

select i.userid,i.userName,i.investmoneytype,i.investmoney,i.investrequesttime,
                     i.investhandletime,i.investbankcode,i.state from bk_invest_money i;


select i.userid,i.userName,i.investmoneytype,i.investmoney,i.investrequesttime,
       i.investhandletime,i.investbankcode,i.investstate from bk_invest_money i ;

-- 用户表（客户）
drop table if exists bk_user_info;
create table bk_user_info(
    userid int(10) primary key auto_increment, -- 主键
    username varchar(20),-- 账号
    usercode int(10),-- 客户编号
    iphone varchar(11),-- 手机号
    pwd varchar(20), -- 密码
    nickname varchar(20), -- 昵称
    sex int(1), -- 性别 1为男  0为女
    birthday date,
    avatarcolor varchar(50), -- 爱好
    grade int(10), -- 等级
    headpic varchar(100), -- 头像大图
    headpicthumb varchar(200), -- 头像缩略图
    state int(10) default 1 -- 状态 1为可用  0为删除
);
insert into bk_user_info values(userid,?,?,?,?,?,?,?,?,?,?,?,1);

select count(userid) from bk_user_info;

select u.usercode ,u.username,u.iphone,c.com_name comName,a.holdnumber,a.holdmoney
from bk_user_info u,bk_customer_assets a,company_info c where u.userid = a.userid and a.com_id = c.com_id;

-- 独角兽🦄公司信息表
drop table if exists company_info;
create table company_info
(
    com_id          int(10) primary key auto_increment comment '主键',
    com_name        varchar(50) comment '企业名称',
    trade_code      varchar(50) comment '交易代码',
    com_logo        varchar(255) comment '企业logo',
    app_logo        varchar(255) comment 'app_logo',
    com_industry    varchar(50) comment '所属行业',
    com_create_year varchar(50) comment '成立年份',
    com_ceo         varchar(50) comment '企业执行官',
    com_location    varchar(100) comment '企业所在地',
    com_rate        float(10, 2) comment '费率',
    new_maker_amount float(10,0) comment '最新挂牌价',
    com_seq_code    int(10) comment '企业顺序码',
    com_intro       varchar(500) comment '企业介绍',
    com_info_state  int(10) default 1 comment '公司信息状态'
);
select c.com_id comId,c.com_name comName,c.trade_code tradeCode,
       c.com_logo comLoge,c.app_logo appLogo,c.com_industry comIndustry,
       c.com_create_year comCreateYear,c.com_ceo comCeo,c.com_location comLocation,
       c.com_rate comRate,c.new_maker_amount newMakerAmount,c.com_seq_code comSeqCode,
       c.com_intro comIntro,m.buyPriceOne,m.buyNumberOne,m.buyPriceTwo,m.buyNumberTwo,
       m.buyPriceThree,m.buyNumberThree
from company_info c,maker_price m where c.com_id = m.com_id and c.com_info_state =1;




select c.com_name comName,c.trade_code tradeCode,c.com_seq_code comSeqCode,
       c.new_maker_amount newMakerAmount from company_info c;

insert into company_info
values (com_id, '步长制药', '603858', 'img/步长制药.webp', 'img/步长制药app.webp', '医药生物', '2001', '赵涛', '山东', 1.5,161.55, 1,
        '山东步长制药股份有限公司(简称“步长制药”)成立于2001年,并于2012年完成股份制改制。2016年7月通过证监会发审会IPO审核,于2016年11月18日成功上市。', com_info_state);
insert into company_info
values (com_id, '盘江股份', '600395', 'img/盘江股份.webp', 'img/盘江股份app.webp', '化石能源', '1999', '朱家道', '贵州', 1.5,9.48, 2,
        '贵州盘江精煤股份有限公司是1999年经贵州省人民政府批准,由盘江煤电集团公司作为主发起人,联合中煤进出口公司、贵阳特钢公司、防城港务局等七家单位共同发起设立的股份制企业,“盘江股份”于2001年5月在上交所正式挂牌交易。',
        com_info_state);
insert into company_info
values (com_id, '祁连山', '600720', 'img/祁连山.webp', 'img/祁连山app.webp', '制造业', '1996', '脱利成', '甘肃', 1.5,14.94, 3,
        '公司于1996年7月12日在“一五”时期全国156个重点工业项目永登水泥厂的基础上经过股份制改制设立,1996年7月16日公司股票在上海证券交易所挂牌上市,股票简称:祁连山,股票代码:600720,是甘肃省第二家上市公司。',
        com_info_state);
insert into company_info
values (com_id, '通威股份', '600438', 'img/通威股份.webp', 'img/通威股份app.webp', '农林牧渔', '1995', '谢毅', '四川', 1.5,41.74, 4,
        '	通威股份有限公司由通威集团控股,是以农业、新能源双主业为核心的大型民营科技型上市公司。公司现拥有遍布全国及海外的200余家分、子公司,员工2.5万余人,年饲料生产能力超过1000万吨',
        com_info_state);
insert into company_info
values (com_id, '韦尔股份', '603501', 'img/韦尔股份.png', 'img/韦尔股份app.jpg', '电子设备', '2007', '虞仁荣', '上海', 1.5,12.57, 5,
        '上海韦尔半导体股份有限公司是一家以自主研发、销售服务为主体的半导体器件设计和销售公司,公司成立于2007年5月,总部坐落于有“中国硅谷”之称的上海张江高科技园区,在深圳、台湾、香港等地设立办事处。',
        com_info_state);
insert into company_info
values (com_id, '奥飞娱乐', '002292', 'img/奥飞娱乐.webp', 'img/奥飞娱乐app.webp', '文化传媒', '1997', '蔡东青', '广东', 1.5,5.51, 6,
        '奥飞娱乐股份有限公司(SZ:002292)是中国目前最具实力和发展潜力的动漫及娱乐文化产业集团公司之一,以发展民族动漫文化产业,让快乐与梦想无处不在为使命,致力构筑东方迪士尼。', com_info_state);
insert into company_info
values (com_id, '海南发展', '002163', 'img/海南发展.webp', 'img/海南发展app.webp', '建材', '1995', '朱强华', '广东', 1.5,13.47, 7,
        '海控南海发展股份有限公司(简称:海南发展),前身为中航三鑫股份有限公司,创立于1995年,总部设在深圳。公司于2007年成功在深交所挂牌上市,股票代码:002163,是海南省国有资产监督管理委员会所属海南省发展控股有限公司旗下的国有上市公司。',
        com_info_state);
insert into company_info
values (com_id, '山东墨龙', '002490', 'img/山东墨龙.webp', 'img/山东墨龙app.webp', '机械设备', '2001', '杨云龙', '山东', 1.5,4.04, 8,
        '山东墨龙石油机械股份有限公司是一家专业从事石油机械设计研究、加工制造、销售服务和出口贸易的上市公司,产品主要有油管、套管、石油专用无缝管、抽油杆、抽油泵、抽油机、潜油电泵、注液泵及各种井下工具等,是中国四大石油集团公司的合资格供应商,是中石油I类产品四大优秀供应商之一。',
        com_info_state);
insert into company_info
values (com_id, '珠海港', '000507', 'img/珠海港.webp', 'img/珠海港app.gif', '交通运输', '1986', '欧辉生', '广东', 1.5,6.10, 9,
        '珠海港股份有限公司是我国沿海24个主枢纽港和广东省5个主要港口之一,是珠江口西岸地理位置和建港条件最为优越的深水良港。珠海港股份有限公司,前身为“珠海经济特区富华集团股份有限公司”,1993年在深交所上市,是深交所最早期的异地上市公司之一。',
        com_info_state);
insert into company_info
values (com_id, '滨江集团', '002244', 'img/滨江集团.webp', 'img/滨江集团app.webp', '房地产', '1996', '戚金兴', '浙江', 1.5,8.17, 10,
        '杭州滨江房产集团股份有限公司成立于1992年,具有建设部一级开发资质,全国民营企业500强,中国房地产企业50强,长三角房地产领军企业。公司秉承“创造生活,建筑家”的专业理念,形成了“团队、管理、品牌、金融、合作、服务”六大核心竞争优势。',
        com_info_state);
insert into company_info
values (com_id, '雅迪控股', '01585', 'img/雅迪控股.webp', 'img/雅迪控股app.webp', '汽车', '2001', '董经贵', '香港', 1.5,13.42, 11,
        '雅迪集团控股有限公司创立于2001年,经过十几年的高速发展,现已成为集电动自行车、电动摩托车及其零配件研发、生产与销售于一体的高端两轮电动车制造企业。2016年5月19日,雅迪在香港成功上市(股票代码:01585.HK)。',
        com_info_state);
insert into company_info
values (com_id, '京东健康', '06618', 'img/京东健康.webp', 'img/京东健康app.webp', '药品及生物科技', '2018', '刘强东', '香港', 1.5,47.55, 12,
        '京东健康股份有限公司是一家主要从事“互联网+医疗健康”生态系统业务的中国投资控股公司。该公司主要为客户提供医药和健康产品、互联网医疗、健康管理及智能医疗保健解决方案及为业务合作夥伴提供市场营销服务。该公司主要在国内市场开展业务。',
        com_info_state);
insert into company_info
values (com_id, '招商银行', '03968', 'img/招商银行.webp', 'img/招商银行app.webp', '银行', '1987', '缪建民', '广东', 1.5,38.50, 13,
        '招商银行股份有限公司1987年成立于中国改革开放的最前沿——深圳蛇口,是中国境内第一家完全由企业法人持股的股份制商业银行,也是国家从体制外推动改革的第一家试点银行,现已发展成为沪港两地上市,拥有商业银行、金融租赁、基金管理、人寿保险、境外投行等金融牌照的银行集团。',
        com_info_state);
insert into company_info
values (com_id, '猫眼娱乐', '01896', 'img/猫眼娱乐.webp', 'img/猫眼娱乐app.webp', '媒体及娱乐', '2017', '王长田', '香港', 1.5,5.76, 14,
        '猫眼娱乐是一家主要运营创新互联网娱乐服务平台的中国公司,公司寻求建立一个围绕本公司综合性平台的充满活力的生态系统,连接并赋能消费者和娱乐行业,达成本公司的使命。本公司致力于借助互联网的力量使消费者能够轻松发现和享受高质量的娱乐内容。',
        com_info_state);
insert into company_info
values (com_id, '利福国际', '01212', 'img/利福国际.webp', 'img/利福国际app.gif', '专业零售', '2003', '刘銮鸿', '香港', 1.5,3.51, 15,
        '利福国际集团有限公司(连同其附属公司,‘本集团’)是扎根于香港的龙头零售营运商,在香港专门经营中高档次百货店。本集团的两家崇光百货分别为全港最大型位于铜锣湾的旗舰店(‘铜锣湾崇光’)以及尖沙咀店。凭藉量身定制的商品及服务组合,崇光百货确立其作为香港旅客及本地消费者首选的购物热点。',
        com_info_state);
-- 挂单价格表
drop table if exists maker_price;
create table maker_price
(
    maker_id     int(10) primary key auto_increment comment '主键',
    com_id       int(10) comment '企业编号',
    buyPriceOne  float(10,2),
    buyNumberOne  float(10,2),
    buyPriceTwo   float(10,2),
    buyNumberTwo   float(10,2),
    buyPriceThree    float(10,2),
    buyNumberThree   float(10,2)

);

update maker_price set buyPriceOne=?,buyNumberOne=?,buyPriceTwo=?,buyNumberTwo=?,
                       buyPriceThree=?,buyNumberThree=? where com_id = ?;


insert into maker_price values (maker_id, 1, 161.51, 11, 161.54, 19, 161.55, 24);
insert into maker_price values (maker_id, 2, 161.45, 35, 161.44, 49, 161.40, 5);
insert into maker_price values (maker_id, 3, 61.51, 12, 61.54, 19, 61.55, 25);
insert into maker_price values (maker_id, 4, 16.41, 11, 16.54, 17, 16.65, 10);
insert into maker_price values (maker_id, 5, 9.45, 94, 9.46, 959, 9.48, 61);
insert into maker_price values (maker_id, 6, 9.44, 354, 9.43, 692, 9.42, 56);
insert into maker_price values (maker_id, 7, 14.92, 174, 14.93, 1332, 14.94, 175);
insert into maker_price values (maker_id, 8, 14.91, 26, 14.90, 132, 14.88, 6);
insert into maker_price values (maker_id, 9, 41.71, 34, 41.73, 1, 41.74, 7);
insert into maker_price values (maker_id, 10, 41.70, 2, 41.67, 45, 41.66, 172);
insert into maker_price values (maker_id, 11, 23.55, 631, 23.56, 50, 23.57, 51);
insert into maker_price values (maker_id, 12, 23.53, 56, 23.51, 30, 23.57, 51);
insert into maker_price values (maker_id, 13, 10.53, 110, 10.55, 50, 10.59, 20);
insert into maker_price values (maker_id, 14, 43.71, 20, 43.74, 4, 43.75, 3);
insert into maker_price values (maker_id, 15, 78.21, 100, 78.24, 50, 78.25, 60);


insert into maker_price
values (maker_id, 5, 161.51, 11, 0);
insert into maker_price
values (maker_id, 5, 161.54, 19, 0);
insert into maker_price
values (maker_id, 5, 161.55, 24, 0);

insert into maker_price
values (maker_id, 5, 161.45, 35, 1);
insert into maker_price
values (maker_id, 5, 161.44, 49, 1);
insert into maker_price
values (maker_id, 5, 161.40, 5, 1);

insert into maker_price
values (maker_id, 2, 9.45, 94, 0);
insert into maker_price
values (maker_id, 2, 9.46, 959, 0);
insert into maker_price
values (maker_id, 2, 9.48, 61, 0);

insert into maker_price
values (maker_id, 2, 9.44, 354, 1);
insert into maker_price
values (maker_id, 2, 9.43, 692, 1);
insert into maker_price
values (maker_id, 2, 9.42, 56, 1);

insert into maker_price
values (maker_id, 3, 14.92, 174, 0);
insert into maker_price
values (maker_id, 3, 14.93, 1332, 0);
insert into maker_price
values (maker_id, 3, 14.94, 175, 0);

insert into maker_price
values (maker_id, 3, 14.91, 26, 1);
insert into maker_price
values (maker_id, 3, 14.90, 132, 1);
insert into maker_price
values (maker_id, 3, 14.88, 6, 1);

insert into maker_price
values (maker_id, 4, 41.71, 34, 0);
insert into maker_price
values (maker_id, 4, 41.73, 1, 0);
insert into maker_price
values (maker_id, 4, 41.74, 7, 0);

insert into maker_price
values (maker_id, 4, 41.70, 2, 1);
insert into maker_price
values (maker_id, 4, 41.67, 45, 1);
insert into maker_price
values (maker_id, 4, 41.66, 172, 1);

insert into maker_price
values (maker_id, 1, 23.55, 631, 0);
insert into maker_price
values (maker_id, 1, 23.56, 50, 0);
insert into maker_price
values (maker_id, 1, 23.57, 51, 0);

insert into maker_price
values (maker_id, 1, 23.53, 56, 1);
insert into maker_price
values (maker_id, 1, 23.51, 30, 1);
insert into maker_price
values (maker_id, 1, 23.50, 23, 1);
-- 历史融资表
drop table if exists history_funding;
create table history_funding
(
    hy_fun_id       int(10) primary key auto_increment comment '主键',
    com_id          int(10) comment '公司编号',
    fun_date        date comment '投资日期',
    fun_type        varchar(50) comment '投资方式',
    fun_amount      int(10) comment '投资金额(百万)',
    after_fun_val   int(10) comment '投后估值(百万)',
    total_shares    int(10) comment '总发行股数(百万)',
    price_per_share int(10) comment '每股单价',
    hy_fun_state    int(10) default 1 comment '历史融资表状态'
);

select c.com_name comName,h.fun_date funDate,h.fun_type funType,
       h.fun_amount funAmount,h.after_fun_val aftreFunVal,h.total_shares totalShares,
       h.price_per_share pricePerShare from history_funding h,company_info c where h.com_id=c.com_id and c.com_id =1;


select c.com_name comName,h.fun_date funDate,h.fun_type funType,h.fun_amount funAmount,
       h.after_fun_val afterFunVal,h.total_shares totalShares,h.price_per_share pricePerShare
       from company_info c ,history_funding h where c.com_id = h.com_id and c.com_id = 1;

select c.com_name comName,c.trade_code tradeCode,c.com_seq_code comSeqCode,
                      c.new_maker_amount newMakerAmount from company_info c where  c.com_name  like;


insert into history_funding
values(hy_fun_id,1,'1997-02-28','天使轮',1,2,1,2,hy_fun_state);
insert into history_funding
values(hy_fun_id,1,'2002-02-02','A轮',5,10,1,7,hy_fun_state);
insert into history_funding
values(hy_fun_id,1,'2004-02-02','B轮',10,345,23,15,hy_fun_state);
insert into history_funding
values(hy_fun_id,1,'2004-12-02','C轮',25,575,25,23,hy_fun_state);
insert into history_funding
values(hy_fun_id,1,'2008-09-09','D轮',50,120,30,40,hy_fun_state);

insert into history_funding
values(hy_fun_id,2,'2000-04-28','天使轮',5,3,1,3,hy_fun_state);
insert into history_funding
values(hy_fun_id,2,'2004-06-02','A轮',10,15,5,8,hy_fun_state);
insert into history_funding
values(hy_fun_id,2,'2006-02-02','B轮',20,350,25,15,hy_fun_state);
insert into history_funding
values(hy_fun_id,2,'2006-12-02','C轮',30,550,30,23,hy_fun_state);
insert into history_funding
values(hy_fun_id,2,'2010-09-09','D轮',60,120,30,40,hy_fun_state);

insert into history_funding
values(hy_fun_id,3,'2001-04-28','天使轮',5,2,1,2,hy_fun_state);
insert into history_funding
values(hy_fun_id,3,'2005-06-02','A轮',10,15,1,8,hy_fun_state);
insert into history_funding
values(hy_fun_id,3,'2007-06-02','B轮',15,300,20,15,hy_fun_state);
insert into history_funding
values(hy_fun_id,3,'2007-10-02','C轮',30,550,30,25,hy_fun_state);
insert into history_funding
values(hy_fun_id,3,'2010-10-09','D轮',60,120,30,40,hy_fun_state);

insert into history_funding
values(hy_fun_id,4,'2002-04-28','天使轮',1,2,1,2,hy_fun_state);
insert into history_funding
values(hy_fun_id,4,'2005-06-02','A轮',5,10,1,8,hy_fun_state);
insert into history_funding
values(hy_fun_id,4,'2008-06-02','B轮',15,300,20,15,hy_fun_state);
insert into history_funding
values(hy_fun_id,4,'2008-11-11','C轮',25,600,25,20,hy_fun_state);
insert into history_funding
values(hy_fun_id,4,'2010-10-09','D轮',60,100,30,35,hy_fun_state);

insert into history_funding
values(hy_fun_id,5,'2000-05-20','天使轮',4,4,1,3,hy_fun_state);
insert into history_funding
values(hy_fun_id,5,'2005-07-17','A轮',10,10,1,8,hy_fun_state);
insert into history_funding
values(hy_fun_id,5,'2008-08-02','B轮',20,400,22,16,hy_fun_state);
insert into history_funding
values(hy_fun_id,5,'2008-12-11','C轮',30,600,25,24,hy_fun_state);
insert into history_funding
values(hy_fun_id,5,'2010-10-09','D轮',60,300,40,40,hy_fun_state);




-- 在表中添加一列
 -- alter table bk_business_info add business_state int(10);



select c.com_name comName,c.trade_code tradeCode,c.com_seq_code comSeqCode,
       c.new_maker_amount newMakerAmount from company_info c where c.com_name  like '%步长制药%';


select * from  maker_price;
select count(c.com_id) from company_info as c, maker_price as p
 where  c.com_id =  p.com_id and c.com_info_state =1;

select c.com_id comId,c.com_name comName,c.trade_code tradeCode,
          c.com_logo comLogo,c.app_logo appLogo,c.com_industry comIndustry,
          c.com_create_year comCreateYear,c.com_ceo comCeo,c.com_location comLocation,
          c.com_rate comRate,c.new_maker_amount newMakerAmount,c.com_seq_code comSeqCode,
          c.com_intro comIntro,m.buyPriceOne,m.buyNumberOne,m.buyPriceTwo,m.buyNumberTwo,
          m.buyPriceThree,m.buyNumberThree
   from company_info c,maker_price m where c.com_id = m.com_id and c.com_info_state =1



select i.userid,i.userName,i.investmoneytype,u.iphone,i.investmoney,i.investrequesttime,
                     i.investhandletime,i.investbankcode,i.state from bk_invest_money i, bk_user_info u where i.userid=u.userid


select count(i.investmoneyid) from bk_invest_money i,bk_user_info u where i.userid=u.userid





select i.userid,i.userCode,i.userName,i.investmoneytype,i.investmoney,i.investrequesttime,
       i.investhandletime,i.investbankcode,i.state,u.iphone from bk_invest_money i,bk_user_info u where i.userid = u.userid  limit 0,5;

