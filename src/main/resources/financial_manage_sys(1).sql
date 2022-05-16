#
CREATE
    DATABASE IF NOT EXISTS financial_manage_sys;

#

#
# -- 用户信息
#
drop table if exists bk_user_info;
#
create table bk_user_info
    #
(
    # user_id int
    (
    10
) primary key auto_increment comment '主键',
    # user_name varchar
    (
    50
) comment '用户名',
    # head_pic varchar ( 50
) comment '头像大图',
    # head_pic_thumb varchar (
    50
    ) comment '头像缩略图',
    # des varchar (
    50
    ) comment '个性签名',
    # sex int (
    10
    ) comment '性别',
    # birthday date comment '生日',
    # avatar_color varchar (
    50
    ) comment '爱好',
    # phone varchar (
    11
    ) comment '手机号',
    # grade int (
    10
    ) comment '等级',
    # create_time datetime default now (
    ) comment '创建时间'
# );
#
# -- 用户角色中间表
#
drop table if exists m_user_role;
#
create table m_user_role
    #
(
    # user_id int
    (
    10
),
    # role_id int
    (
    10
)
    # );
#
# -- 用户角色
#
drop table if exists user_role;
#
create table user_role
    #
(
    # role_id int
    (
    10
) primary key auto_increment comment '角色编号',
    # role_code varchar
    (
    50
) comment '角色对应实体类',
    # role_name varchar ( 50
) comment '角色名称',
    # sort int (
    10
    ) comment '排序'
# );
#
# -- 用户角色-权限中间表
#
drop table if exists m_role_permission;
#
create table m_role_permission
    #
(
    # role_id int
    (
    10
) comment '角色编号',
    # permission_id int
    (
    10
) comment '权限编号'
    # );
#
# -- 用户权限表
#
drop table if exists user_permission;
#
create table user_permission
    #
(
    # permission_id int
    (
    10
) primary key auto_increment comment '权限编号',
    # permission_code varchar
    (
    50
) comment '权限对应实体类',
    # permission_name varchar ( 50
) comment '权限名称',
    # permission_path varchar (
    255
    ) comment '权限来源',
    # permission_image varchar (
    255
    ) comment '权限图标'
# );


/*
 **********************************企业管理模块*************************************
 */

-- 证券市值，用户持有的理财产品金额
drop table if exists bk_customer_assets;
create table bk_customer_assets
(
    customer_id    int(10) primary key auto_increment comment '主键',
    user_id        int(10) comment '客户id',
    co_business_id int(10) comment '企业id',
    hold_number    int(10) comment '持有数量',
    hold_money     float(10, 2) comment '成本价格',
    state          int(10) default 1 comment '状态' -- 0.删除  1.可用
);
insert into bk_customer_assets values (customer_id);
-- 充值提现管理
drop table if exists bk_invest_money;
CREATE table bk_invest_money
(
    invest_money_id     int(10) primary key auto_increment comment '主键',
    user_id             int(10) comment '客户id',
    invest_money_type   int(10) comment '交易类型',
    invest_money        float(10, 2) comment '交易金额',
    invest_request_time timestamp comment '请求时间',
    invest_handle_time  timestamp comment '处理时间',
    invest_bank_code    int(10) comment '银行代码',
    invest_state        int(10) comment '汇款状态',
    -- 2:已汇款到用户
    state int (10) default 1 comment  '状态' -- 0.删除  1.可用
);

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
    com_seq_code    int(10) comment '企业顺序码',
    com_intro       varchar(500) comment '企业介绍',
    com_info_state  int(10) default 1 comment '公司信息状态'
);

insert into company_info values(com_id,'迪马股份','600565',?,?,'房地产行业','1997','罗韶颖','重庆','1.5%',1,'重庆市迪马实业股份有限公司(SH.600565)是国内领先的上市实业集团(SH.600565),创立于1997年,2002年在上海证券交易所上市,是重庆市第一家民营上市企业,中国特种车行业第一家上市公司。',com_info_state);
insert into company_info values(com_id,'亚士创能','603378',?,?,'基础化工','1998','李金钟','上海','1.5%',2,'亚士创能科技(上海)股份有限公司成立于1998年,是一家集建筑装饰涂料、保温装饰板、防火保温材料、防水材料的研发,制造,服务于一体的高新技术企业。公司连续10年荣获中国房地产开发企业500强首选供应商。',com_info_state);
insert into company_info values(com_id,'步长制药','603858',?,?,'医药生物','2001','赵涛','	山东','1.5%',3,'山东步长制药股份有限公司(简称“步长制药”)成立于2001年,并于2012年完成股份制改制。2016年7月通过证监会发审会IPO审核,于2016年11月18日成功上市。 在19年的发展中,步长制药构建了清晰的发展战略。',com_info_state);
insert into company_info values(com_id,'中伟股份','300919',?,?,'电子设备','2014','邓伟明','贵州','1.5%',4,'中伟新材料股份有限公司(中伟股份300919.SZ)成立于2014年9月,是湖南中伟控股集团有限公司旗下控股子公司、上市主体,公司被认定为国家企业技术中心、国家高新技术企业,获得“国家智能制造”、“绿色制造工厂”等示范项目称号。',com_info_state);
insert into company_info values(com_id,'盛力达科技','01289',?,?,'工业工程','2006','张德刚','无锡','1.5%',5,'无锡盛力达科技股份有限公司是中国钢丝制品生产整体解决方案提供商。集团的主要业务是根据客户的特定生产要求,提供制造钢丝制品的生产线的研发、设计、制造、供应设备、安装、调试及维修保养服务。',com_info_state);
insert into company_info values(com_id,'长安仁恒','08139',?,?,'原材料','2008','张有连','浙江','1.5%',6,'浙江长安仁恒科技股份有限公司位于浙江省长兴县泗安经济开发区,地处浙江省西北部,太湖西南岸,地处长三角中心腹地,属边界商贸重镇。周边200公里范围内分布着上海、杭州、南京、苏州、无锡、宁波等52个大中城市,处于长三角庞大经济圈的中央区块。',com_info_state);
insert into company_info values(com_id,'伊泰煤炭','03948',?,?,'煤炭','1997','张晶泉','内蒙古','1.5%',7,' 内蒙古伊泰煤炭股份有限公司(以下简称“公司”),是由内蒙古伊泰集团有限公司独家发起,募集设立的B+H股上市公司。 公司创立于1997年8月,并于同年在上海证券交易所上市,股票简称“伊泰B股”(股票代码900948);公司于2012年7月在香港证券交易所上市,股票简称“伊泰煤炭”(股票代码3948)',com_info_state);
insert into company_info values(com_id,'碧桂园','02007',?,?,'地产','2006','杨国强','香港','1.5%',8,'碧桂园控股有限公司是为社会创造幸福生活的高科技综合性企业 本公司控股有限公司积极投身机器人产业 科技发展日新月异,机器人时代已经到来。',com_info_state);
insert into company_info values(com_id,'美的置业','03990',?,?,'地产','2017','郝恒乐','香港','1.5%',9,'2021年,行业经历了前所未有的考验。展望未来,仍然道阻且长。但人们对於美好生活的向往将一直存在,作为「住有所居,居有所安」的实现纽带,房地产行业的未来一定大有可为。',com_info_state);
insert into company_info values(com_id,'海底捞','06862',?,?,'酒店','2015','张勇','香港','1.5%',10,'海底捞国际控股有限公司是全球领先、快速增长的中式餐饮品牌,主打火锅品类。本公司认为,海底捞品牌在中式餐饮行业已经形成一种独特的文化现象,成为极致服务体验和就餐体验的代名词。',com_info_state);
insert into company_info values(com_id,'汇金股份','300368',?,?,'信息技术','2005','崔仲民','石家庄','1.5%',11,'河北汇金集团股份有限公司成立于2005年3月,目前注册资本53,194.35万元,占地8万多平方米。公司于2014年1月23日在深圳证券交易所挂牌上市,股票简称“汇金股份”,股票代码300368。公司主营业务主要分为智能制造业务和信息化综合解决方案与技术服务业务。',com_info_state);
insert into company_info values(com_id,'深粮控股','000019',?,?,'食品饮料','1984','祝俊明','深圳','1.5%',12,'圳市深粮控股股份有限公司(以下简称:深粮控股)是深圳市市属国有大型粮食企业,是深圳市的“米袋子”,受政府委托,承担广东省、深圳市、东莞市和湛江市等省市的地方粮食储备,同时负责驻港、驻深部队和武警部队的军粮供应任务,是我国华南地区粮油产品供应的主渠道',com_info_state);
insert into company_info values(com_id,'安道麦A','000553',?,?,'基础化工','1998','Erik Fyrwald','湖北','1.5%',13,'安道麦股份有限公司是全球作物保护行业的领军企业之一。我们致力于创造农业简单化,为农民提供高效的产品和服务,简便农民的农作生活并帮助农民发展。',com_info_state);
insert into company_info values(com_id,'三峡能源	','600905',?,?,'公用事业','1985','王武斌','北京','1.5%',14,'中国三峡新能源(集团)股份有限公司(以下简称三峡能源,股票代码:600905)作为三峡集团新能源业务的战略实施主体,承载着发展新能源的历史使命。 近年来,三峡能源积极发展陆上风电、光伏发电,大力开发海上风电,深入推动源网荷储一体化和多能互补发展,积极开展抽水蓄能、储能、氢能等业务',com_info_state);
insert into company_info values(com_id,'爱玛科技','603529',?,?,'交运设备','1999','张剑','天津','1.5%',15,'爱玛科技集团股份有限公司成立于1999年,并于2004年步入电动自行车行业,是中国最早的电动自行车制造商之一。公司主营业务为电动自行车、电动轻便摩托车、电动摩托车等的研发、生产及销售,自股份公司设立以来未发生变化。',com_info_state);







-- 挂单价格表
drop table if exists maker_price;
create table maker_price
(
    maker_id     int(10) primary key auto_increment comment '主键',
    com_id       int(10) comment '企业编号',
    maker_amount float(10, 2) comment '挂单金额',      -- 单价
    trade_amount int(10) comment '交易数量',
    maker_state  int(10) default 1 comment '挂单表状态' -- 0:买入  1：卖出
);

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



/*
 **********************************产品管理模块*************************************
 */
-- 产品信息表
drop table if exists product_info;
create table product_info
(
    product_id             int(10) primary key auto_increment comment '主键',
    product_type_id        int(10) comment '产品分类id',
    regulate_body          varchar(50) comment '管理机构',
    product_ch_name        varchar(50) comment '产品中文名称',
    product_eng_name       varchar(50) comment '产品英文名称',
    annual_yield           float(10, 4) comment '年化收益率',
    currency_type          int comment '货币类型',
    open_time              date comment '开放时间',
    sub_cycle              int(10) comment '认购周期',
    fund_manage_fee_rate   float(10, 4) comment '基金管理费率',
    sub_rate               float(10, 4) comment '认购费率',
    init_invest_amount     float(10, 2) comment '起投金额',
    sub_fee_collect_method int comment '认购费收取方式',
    red_cycle              int(10) comment '赎回周期',
    red_init_amount        float(10, 2) comment '赎回起始金额',
    red_amount             float(10, 4) comment '赎回费用',
    lock_period            int(10) comment '锁定期',
    pro_info_state         int(10) default 1 comment '产品信息状态'
);


-- 产品推荐表
drop table if exists product_recommend;
create table product_recommend
(
    recommend_id       int(10) primary key auto_increment comment '主键',
    product_id         int(10) comment '产品id',
    recommend_lv       int(10) default 1 comment '推荐度',
    is_visible         int(10) default 0 comment '是否投顾端可见',
    is_ipo             int(10) default 0 comment '是否首发',
    is_online_purchase int(10) default 0 comment '是否线上申购',
    recommend_reason   varchar(255) comment '推荐理由'
);
-- 产品关连表
drop table if exists m_product;
create table m_product
(
    product_id_a int(10) comment '关联产品a',
    product_id_b int(10) comment '关联产品b',
    primary key (`product_id_b`, `product_id_a`)
);


-- 产品审核表
drop table if exists product_audit;
create table product_audit
(
    audit_id           int(10) primary key auto_increment comment '主键',
    product_id         int(10) comment '产品id',
    auditor            varchar(50) comment '审核人',
    auditor_opinion    varchar(255) comment '审核意见',
    first_create_time  timestamp comment '首次创建时间',
    latest_modify_time timestamp comment '最新修改时间',
    audit_state        int(10) comment '产品审核状态'
);

-- 汇款信息表
drop table if exists remit_info;
create table remit_info
(
    remit_id           int(10) primary key auto_increment comment '主键',
    product_type_id    int(10) comment '商品类型编号',
    remit_account      int(10) comment '收款账户',
    remit_postscript   varchar(255) comment '汇款附言',
    remit_info_summary varchar(50) comment '汇款信息概略',
    rec_bank_name      varchar(50) comment '收款银行名称',
    swift_code         varchar(50) comment '银行国际代码',
    bank_code          varchar(50) comment '银行代码',
    cnaps_id           varchar(50) comment '人行系统支付号',
    rec_bank_area      varchar(255) comment '收款银行地区',
    rec_bank_city      varchar(100) comment '收款银行城市',
    rec_account_name   varchar(50) comment '收款人户名',
    rec_account        varchar(50) comment '收款人账号',
    rec_location       varchar(255) comment '收款人地址',
    rec_state          int(10) default 1 comment '收款状态'
);

-- 产品类型表
drop table if exists product_type;
create table product_type
(
    product_id            int(10) primary key auto_increment comment '主键',
    product_series_id     int(10) comment '产品分类编号',
    product_parent_id     int(10) comment '产品父类编号',
    product_channel       int(10) comment '产品渠道',
    product_type_ch_name  varchar(50) comment '产品类型名称(中文)',
    product_type_eng_name varchar(50) comment '产品类型名称(英文)',
    product_type_lv       int(10) comment '类型级别(0为一级分类)',
    product_type_state    int(10) default 1 comment '产品系类状态'
);

/**
  ************************************基金系列************************************
 */
insert into product_type
values (product_id, 0, 0, 2, '基金', 'fund', 0, product_type_state);
insert into product_type
values (product_id, 0, 0, 2, '保险', 'insurance', 0, product_type_state);
insert into product_type
values (product_id, 0, 0, 2, '证券', 'security', 0, product_type_state);


/**
  *******************************股票型*************************************
 */
insert into product_type
values (product_id, 1, 1, 2, '富国中证煤炭指数(LOF)', 'LOF', 1, product_type_state);

insert into product_type
values (product_id, 1, 1, 2, '招商中证煤炭等权指数(LOF)', 'LOF', 1, product_type_state);

insert into product_type
values (product_id, 1, 1, 2, '国泰中证煤炭ETF联接', 'ETF', 1, product_type_state);

insert into product_type
values (product_id, 1, 1, 2, '中融中证煤炭指数', 'LOF', 1, product_type_state);

insert into product_type
values (product_id, 1, 1, 2, '创金合信红利低波动', 'LOF', 1, product_type_state);

insert into product_type
values (product_id, 1, 1, 2, '西部利得国企红利(LOF)', 'LOF', 1, product_type_state);



insert into product_type
values (product_id, 1, 4, 2, '富国中证煤炭指数(LOF)A', '161032', 2, product_type_state);

insert into product_type
values (product_id, 1, 4, 2, '富国中证煤炭指数(LOF)C', '013275', 2, product_type_state);

insert into product_type
values (product_id, 1, 5, 2, '招商中证煤炭等权指数(LOF)A', '161724', 2, product_type_state);

insert into product_type
values (product_id, 1, 5, 2, '招商中证煤炭等权指数(LOF)C', '013596', 2, product_type_state);

insert into product_type
values (product_id, 1, 6, 2, '国泰中证煤炭ETF联接A', '008279', 2, product_type_state);

insert into product_type
values (product_id, 1, 6, 2, '国泰中证煤炭ETF联接C', '008280', 2, product_type_state);

insert into product_type
values (product_id, 1, 7, 2, '中融中证煤炭指数(LOF)', '168204', 2, product_type_state);

insert into product_type
values (product_id, 1, 8, 2, '创金合信红利低波动C', '005562', 2, product_type_state);

insert into product_type
values (product_id, 1, 9, 2, '西部利得国企红利(LOF)A', '501059', 2, product_type_state);

insert into product_type
values (product_id, 1, 9, 2, '西部利得国企红利(LOF)C', '009439', 2, product_type_state);


/**
  *******************************混合型*************************************
 */
insert into product_type
values (product_id, 2, 1, 2, '万家宏观择时多策略混合', 'LOF', 1, product_type_state);

insert into product_type
values (product_id, 2, 1, 2, '万家新利灵活配置混合', 'LOF', 1, product_type_state);

insert into product_type
values (product_id, 2, 1, 2, '华夏饲料豆粕期货ETF联接', 'ETF', 1, product_type_state);

insert into product_type
values (product_id, 2, 1, 2, '万家精选混合', 'LOF', 1, product_type_state);

insert into product_type
values (product_id, 2, 1, 2, '招商稳健平衡混合', 'LOF', 1, product_type_state);

insert into product_type
values (product_id, 2, 1, 2, '景顺长城安鑫回报混合', 'LOF', 1, product_type_state);



insert into product_type
values (product_id, 2, 20, 2, '万家宏观择时多策略混合', '519212', 2, product_type_state);

insert into product_type
values (product_id, 2, 21, 2, '万家新利灵活配置混合', '519191', 2, product_type_state);

insert into product_type
values (product_id, 2, 22, 2, '华夏饲料豆粕期货ETF联接A', '007937', 2, product_type_state);

insert into product_type
values (product_id, 2, 23, 2, '万家精选混合A', '519185', 2, product_type_state);

insert into product_type
values (product_id, 2, 24, 2, '招商稳健平衡混合A', '012963', 2, product_type_state);

insert into product_type
values (product_id, 2, 24, 2, '招商稳健平衡混合C', '012964', 2, product_type_state);

insert into product_type
values (product_id, 2, 25, 2, '景顺长城安鑫回报混合A', '009499', 2, product_type_state);

insert into product_type
values (product_id, 2, 25, 2, '景顺长城安鑫回报混合C', '009755', 2, product_type_state);


/**
  *******************************债券型*************************************
 */
insert into product_type
values (product_id, 3, 1, 2, '招商添浩纯债', 'LOF', 1, product_type_state);

insert into product_type
values (product_id, 3, 1, 2, '博时汇享纯债债券', 'LOF', 1, product_type_state);

insert into product_type
values (product_id, 3, 1, 2, '华泰紫金丰泰纯债发起', 'ETF', 1, product_type_state);

insert into product_type
values (product_id, 3, 1, 2, '永赢华嘉信用债', 'LOF', 1, product_type_state);

insert into product_type
values (product_id, 3, 1, 2, '长盛盛裕纯债', 'LOF', 1, product_type_state);

insert into product_type
values (product_id, 3, 1, 2, '光大岁末红利纯债', 'LOF', 1, product_type_state);



insert into product_type
values (product_id, 3, 34, 2, '招商添浩纯债A', '008731', 2, product_type_state);

insert into product_type
values (product_id, 3, 34, 2, '招商添浩纯债C', '008732', 2, product_type_state);

insert into product_type
values (product_id, 3, 35, 2, '博时汇享纯债债券A', '004366', 2, product_type_state);

insert into product_type
values (product_id, 3, 35, 2, '博时汇享纯债债券C', '004367', 2, product_type_state);

insert into product_type
values (product_id, 3, 36, 2, '华泰紫金丰泰纯债发起A', '007117', 2, product_type_state);

insert into product_type
values (product_id, 3, 36, 2, '华泰紫金丰泰纯债发起C', '007118', 2, product_type_state);

insert into product_type
values (product_id, 3, 37, 2, '永赢华嘉信用债A', '010092', 2, product_type_state);

insert into product_type
values (product_id, 3, 37, 2, '永赢华嘉信用债C', '014167', 2, product_type_state);

insert into product_type
values (product_id, 3, 38, 2, '长盛盛裕纯债A', '003102', 2, product_type_state);

insert into product_type
values (product_id, 3, 38, 2, '长盛盛裕纯债C', '003103', 2, product_type_state);

insert into product_type
values (product_id, 3, 39, 2, '光大岁末红利纯债A', '000489', 2, product_type_state);

insert into product_type
values (product_id, 3, 39, 2, '光大岁末红利纯债C', '000490', 2, product_type_state);


/**
  *******************************指数型*************************************
 */
insert into product_type
values (product_id, 4, 1, 2, '广发中证基建工程ETF联接', 'LOF', 1, product_type_state);

insert into product_type
values (product_id, 4, 1, 2, '信诚中证基建工程指数(LOF)', 'LOF', 1, product_type_state);

insert into product_type
values (product_id, 4, 1, 2, '南方房地产ETF联接', 'ETF', 1, product_type_state);

insert into product_type
values (product_id, 4, 1, 2, '南方大盘红利50ETF联接', 'LOF', 1, product_type_state);

insert into product_type
values (product_id, 4, 1, 2, '招商沪深300地产等权重指数', 'LOF', 1, product_type_state);

insert into product_type
values (product_id, 4, 1, 2, '广发中债7-10年国开债指数', 'LOF', 1, product_type_state);



insert into product_type
values (product_id, 4, 52, 2, '广发中证基建工程ETF联接A', '005223', 2, product_type_state);

insert into product_type
values (product_id, 4, 52, 2, '广发中证基建工程ETF联接C', '005224', 2, product_type_state);

insert into product_type
values (product_id, 4, 53, 2, '信诚中证基建工程指数(LOF)A', '165525', 2, product_type_state);

insert into product_type
values (product_id, 4, 53, 2, '信诚中证基建工程指数(LOF)C', '013082', 2, product_type_state);

insert into product_type
values (product_id, 4, 54, 2, '南方房地产ETF联接A', '004642', 2, product_type_state);

insert into product_type
values (product_id, 4, 54, 2, '南方房地产ETF联接C', '004643', 2, product_type_state);

insert into product_type
values (product_id, 4, 55, 2, '南方大盘红利50ETF联接A', '008163', 2, product_type_state);

insert into product_type
values (product_id, 4, 55, 2, '南方大盘红利50ETF联接C', '008164', 2, product_type_state);

insert into product_type
values (product_id, 4, 56, 2, '招商沪深300地产等权重指数A', '161721', 2, product_type_state);

insert into product_type
values (product_id, 4, 56, 2, '招商沪深300地产等权重指数C', '013273', 2, product_type_state);

insert into product_type
values (product_id, 4, 57, 2, '广发中债7-10年国开债指数A', '003376', 2, product_type_state);

insert into product_type
values (product_id, 4, 57, 2, '广发中债7-10年国开债指数E', '011062', 2, product_type_state);

/**
  ************************************保险系列************************************
 */
insert into product_type
values (product_type_id, 2, 2, '重疾保障', 'Disability Insurance', 1, product_type_state);
insert into product_type
values (product_type_id, 2, 2, '年金保险', 'Annuity Insurance', 1, product_type_state);
insert into product_type
values (product_type_id, 2, 2, '年金保险', 'Annuity Insurance', 1, product_type_state);
insert into product_type
values (product_type_id, 2, 2, '年金保险', 'Annuity Insurance', 1, product_type_state);
insert into product_type
values (product_type_id, 2, 2, '年金保险', 'Annuity Insurance', 1, product_type_state);
insert into product_type
values (product_type_id, 2, 2, '少儿/女性/养老保险', 'Children/Women/Endowment  Insurance', 1, product_type_state);
insert into product_type
values (product_type_id, 2, 2, '寿险保障', 'Life Insurance Guarantee', 1, product_type_state);
insert into product_type
values (product_type_id, 2, 2, '医疗保险', 'Medical Insurance', 1, product_type_state);
insert into product_type
values (product_type_id, 2, 2, '意外保障', 'Accident Insurance', 1, product_type_state);
/**
  ************************************证券系列************************************
 */
insert into product_type
values (product_type_id, 3, 2, '意外保障', 'Accident Insurance', 1, product_type_state);


-- 产品类净值表
drop table if exists product_net_value;
create table product_net_value
(
    pro_net_value_id  int(10) primary key auto_increment comment '主键',
    product_id        int(10) comment '产品编号',
    unit_net          float(10, 2) comment '单位净值',
    unit_date         date comment '净值基准日',
    sum_increase_rate float(10, 2) comment '累计增长率'
);



update product_type
set product_parent_id    = ?,
    product_channel      = ?,
    product_type_ch_name=?,
    product_type_eng_name= ?,
    product_type_lv      = ?,
    product_type_state   = ?
where product_type_id = ?;


select count(product_type.product_type_id)
from product_type,
     remit_info
where product_type.product_type_id = remit_info.product_type_id
  and product_type.product_type_id like '%?%'
  and product_type_ch_name like '%?%';

select product_type.product_type_id,
       product_type_ch_name,
       product_type_eng_name,
       remit_info_summary,
       rec_bank_name,
       swift_code,
       bank_code,
       cnaps_id,
       rec_bank_area,
       rec_bank_city,
       rec_account_name,
       rec_account,
       remit_account,
       remit_postscript,
       rec_location
from product_type,
     remit_info
where product_type.product_type_id = remit_info.product_type_id
limit ?,?;







