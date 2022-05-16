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
    state          int(10) comment '状态' -- 0.删除  1.可用
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
    invest_state        int(10) comment '汇款状态',
    -- 2:已汇款到用户
    state               int(10) comment '状态' -- 0.删除  1.可用
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
values (product_id, 5, 2, 2, '重疾保障', 'Disability Insurance', 1, product_type_state);

insert into product_type
values (product_id, 5, 70, 2, '国寿康宁保终身重大疾病保险(2021版,C款)', 'Disability Insurance', 2, product_type_state);
insert into product_type
values (product_id, 5, 70, 2, '国寿康宁保(2021版,A款)', 'Disability Insurance', 2, product_type_state);
insert into product_type
values (product_id, 5, 70, 2, '国寿爱无忧两全保险', 'Disability Insurance', 2, product_type_state);
insert into product_type
values (product_id, 5, 70, 2, '国寿心无忧两全保险', 'Disability Insurance', 2, product_type_state);
insert into product_type
values (product_id, 5, 70, 2, '国寿福(盛典版)', 'Disability Insurance', 2, product_type_state);
insert into product_type
values (product_id, 5, 70, 2, '国寿少儿国寿福(盛典版)产品', 'Disability Insurance', 2, product_type_state);



insert into product_type
values (product_id, 6, 2, 2, '年金保险', 'Annuity Insurance', 1, product_type_state);

insert into product_type
values (product_id, 6, 77, 2, '国寿鑫惠赢两全保险', 'Annuity Insurance', 2, product_type_state);
insert into product_type
values (product_id, 6, 77, 2, '国寿鑫裕尊享年金保险', 'Annuity Insurance', 2, product_type_state);
insert into product_type
values (product_id, 6, 77, 2, '国寿鑫裕年年年金保险', 'Annuity Insurance', 2, product_type_state);
insert into product_type
values (product_id, 6, 77, 2, '国寿鑫裕金生两财两全保险', 'Annuity Insurance', 2, product_type_state);
insert into product_type
values (product_id, 6, 77, 2, '国寿鑫享福养老年金保险', 'Annuity Insurance', 2, product_type_state);
insert into product_type
values (product_id, 6, 77, 2, '国寿鑫耀东方年金保险', 'Annuity Insurance', 2, product_type_state);
insert into product_type
values (product_id, 6, 77, 2, '国寿鑫福临门保险产品组合', 'Annuity Insurance', 2, product_type_state);
insert into product_type
values (product_id, 6, 77, 2, '国寿个人税收递延型养老年金保险(2018版)', 'Annuity Insurance', 2, product_type_state);



insert into product_type
values (product_id, 7, 2, 2, '少儿/女性/养老保险', 'Children/Women/Endowment  Insurance', 1, product_type_state);


insert into product_type
values (product_id, 7, 86, 2, '国寿鑫享宝', 'Children/Women/Endowment  Insurance', 2, product_type_state);
insert into product_type
values (product_id, 7, 86, 2, '国寿锦绣前程少儿两全保险', 'Children/Women/Endowment  Insurance', 2, product_type_state);
insert into product_type
values (product_id, 7, 86, 2, '国寿鑫玉少儿年金保险(分红型)', 'Children/Women/Endowment  Insurance', 2, product_type_state);



insert into product_type
values (product_id, 8, 2, 2, '寿险保障', 'Life Insurance Guarantee', 1, product_type_state);

insert into product_type
values (product_id, 8, 90, 2, '国寿臻享传家终身保险', 'Life Insurance Guarantee', 2, product_type_state);



insert into product_type
values (product_id, 9, 2, 2, '医疗保险', 'Medical Insurance', 1, product_type_state);

insert into product_type
values (product_id, 9, 92, 2, '国寿如E康悦百万医疗保险(盛典版)', 'Medical Insurance', 2, product_type_state);
insert into product_type
values (product_id, 9, 92, 2, '国寿附加特定疾病海外医疗保险', 'Medical Insurance', 2, product_type_state);


insert into product_type
values (product_id, 10, 2, 2, '意外保障', 'Accident Insurance', 1, product_type_state);

insert into product_type
values (product_id, 10, 95, 2, '国寿百万如意行两全保险(盛典版)', 'Accident Insurance', 2, product_type_state);

/**
  ************************************证券系列************************************
 */



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







