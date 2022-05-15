# CREATE DATABASE IF NOT EXISTS financial_manage_sys;

#

#
# -- 用户信息
# drop table if exists bk_user_info;
# create table bk_user_info
# (
#     user_id        int(10) primary key auto_increment comment '主键',
#     user_name      varchar(50) comment '用户名',
#     head_pic       varchar(50) comment '头像大图',
#     head_pic_thumb varchar(50) comment '头像缩略图',
#     des            varchar(50) comment '个性签名',
#     sex            int(10) comment '性别',
#     birthday       date comment '生日',
#     avatar_color   varchar(50) comment '爱好',
#     phone          varchar(11) comment '手机号',
#     grade          int(10) comment '等级',
#     create_time    datetime default now() comment '创建时间'
# );
#
# -- 用户角色中间表
# drop table if exists m_user_role;
# create table m_user_role
# (
#     user_id int(10),
#     role_id int(10)
# );
#
# -- 用户角色
# drop table if exists user_role;
# create table user_role
# (
#     role_id   int(10) primary key auto_increment comment '角色编号',
#     role_code varchar(50) comment '角色对应实体类',
#     role_name varchar(50) comment '角色名称',
#     sort      int(10) comment '排序'
# );
#
# -- 用户角色-权限中间表
# drop table if exists m_role_permission;
# create table m_role_permission
# (
#     role_id       int(10) comment '角色编号',
#     permission_id int(10) comment '权限编号'
# );
#
# -- 用户权限表
# drop table if exists user_permission;
# create table user_permission
# (
#     permission_id    int(10) primary key auto_increment comment '权限编号',
#     permission_code  varchar(50) comment '权限对应实体类',
#     permission_name  varchar(50) comment '权限名称',
#     permission_path  varchar(255) comment '权限来源',
#     permission_image varchar(255) comment '权限图标'
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
    state          int(10) comment '状态'
);
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
    invest_state        int(10) comment '汇款状态'
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

-- 挂单价格表
drop table if exists maker_price;
create table maker_price
(
    maker_id     int(10) primary key auto_increment comment '主键',
    com_id       int(10) comment '企业编号',
    maker_amount float(10, 2) comment '挂单金额',
    trade_amount int(10) comment '交易数量',
    maker_state  int(10) default 1 comment '挂单表状态'
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
    currency_type          varchar(50) comment '货币类型',
    open_time              date comment '开放时间',
    sub_cycle              int(10) comment '认购周期',
    fund_manage_fee_rate   float(10, 4) comment '基金管理费率',
    sub_rate               float(10, 4) comment '认购费率',
    init_invest_amount     float(10, 2) comment '起投金额',
    sub_fee_collect_method varchar(50) comment '认购费收取方式',
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
    user_id            int(10) comment '汇款用户',
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
    product_type_id       int(10) primary key auto_increment comment '主键',
    remit_id              int(10) comment '汇款信息编号',
    product_parent_id     int(10) comment '产品父类编号',
    product_channel       varchar(50) comment '产品渠道',
    product_type_ch_name  varchar(50) comment '产品类型名称(中文)',
    product_type_eng_name varchar(50) comment '产品类型名称(英文)',
    product_type_lv       int(10) comment '类型级别(0为一级分类)',
    product_type_state    int(10) default 1 comment '产品系类状态'
);






