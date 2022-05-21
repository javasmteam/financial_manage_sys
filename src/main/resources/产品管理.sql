/*
 **********************************产品管理模块*************************************
 */
-- 产品信息表
drop table if exists product_info;
create table product_info
(
    product_id             int(10) primary key auto_increment comment '主键',
    product_series_id      int(10) comment '产品系列id',
    sec_id                 int(10) comment '二级分类',
    regulate_body          varchar(50) comment '管理机构',
    product_ch_name        varchar(50) comment '产品中文名称',
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
insert into product_info
values (product_id, 4, 1, '富国基金', '富国中证煤炭指数(LOF)A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3, 200,
        0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 4, 1, '富国基金', '富国中证煤炭指数(LOF)C', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 5, 1, '富国基金', '招商中证煤炭等权指数(LOF)A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 5, 1, '招商基金', '招商中证煤炭等权指数(LOF)C', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 6, 1, '国泰基金', '国泰中证煤炭ETF联接A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3, 200,
        0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 6, 1, '国泰基金', '国泰中证煤炭ETF联接C', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3, 200,
        0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 7, 1, '中融中证基金', '中融中证煤炭指数(LOF)', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 8, 1, '创金合信基金', '创金合信红利低波动C', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3, 200,
        0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 9, 1, '西部利得基金', '西部利得国企红利(LOF)A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 9, 1, '西部利得基金', '西部利得国企红利(LOF)C', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);



insert into product_info
values (product_series_id, 10, 2, '万家宏观基金', '万家宏观择时多策略混合', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 11, 2, '万家新利基金', '万家新利灵活配置混合', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 12, 2, '华夏饲料基金', '华夏饲料豆粕期货ETF联接A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 13, 2, '万家精选基金', '万家精选混合A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 14, 2, '招商基金', '招商稳健平衡混合A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 14, 2, '招商基金', '招商稳健平衡混合C', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 15, 2, '景顺长城基金', '景顺长城安鑫回报混合A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 15, 2, '景顺长城基金', '景顺长城安鑫回报混合C', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);



insert into product_info
values (product_series_id, 16, 3, '招商基金', '招商添浩纯债A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 16, 3, '招商基金', '招商添浩纯债C', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 17, 3, '博时汇享基金', '博时汇享纯债债券A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 17, 3, '博时汇享基金', '博时汇享纯债债券C', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 18, 3, '华泰基金', '华泰紫金丰泰纯债发起A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 18, 3, '华泰基金', '华泰紫金丰泰纯债发起C', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 19, 3, '华嘉信用基金', '永赢华嘉信用债A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 19, 3, '华嘉信用基金', '永赢华嘉信用债C', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 20, 3, '长盛基金', '长盛盛裕纯债A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 20, 3, '长盛基金', '长盛盛裕纯债C', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 21, 3, '光大基金', '光大岁末红利纯债A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 21, 3, '光大基金', '光大岁末红利纯债C', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);



insert into product_info
values (product_series_id, 22, 4, '广发基金', '广发中证基建工程ETF联接A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 22, 4, '广发基金', '广发中证基建工程ETF联接C', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 23, 4, '信诚中证基金', '信诚中证基建工程指数(LOF)A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1,
        3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 23, 4, '信诚中证基金', '信诚中证基建工程指数(LOF)C', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1,
        3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 24, 4, '南方地产基金', '南方房地产ETF联接A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 24, 4, '南方地产基金', '南方房地产ETF联接C', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 25, 4, '南方大盘基金', '南方大盘红利50ETF联接A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 25, 4, '南方大盘基金', '南方大盘红利50ETF联接C', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 26, 4, '招商沪深基金', '招商沪深300地产等权重指数A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1,
        3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 26, 4, '招商沪深基金', '招商沪深300地产等权重指数C', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1,
        3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 27, 4, '广发中债基金', '广发中债7-10年国开债指数A', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1,
        3,
        200, 0.0015, 3, pro_info_state);

insert into product_info
values (product_series_id, 27, 4, '广发中债基金', '广发中债7-10年国开债指数E', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1,
        3,
        200, 0.0015, 3, pro_info_state);



insert into product_info
values (product_series_id, 28, 5, '中国人寿保险有限公司', '国寿康宁保终身重大疾病保险(2021版,C款)', 0.4150, 2, 20150619, 2, 0.002, 0.015,
        2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);
insert into product_info
values (product_series_id, 28, 5, '中国人寿保险有限公司', '国寿康宁保(2021版,A款)', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00,
        1, 3,
        200, 0.0015, 3, pro_info_state);
insert into product_info
values (product_series_id, 28, 5, '中国人寿保险有限公司', '国寿爱无忧两全保险', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);
insert into product_info
values (product_series_id, 28, 5, '中国人寿保险有限公司', '国寿心无忧两全保险', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);
insert into product_info
values (product_series_id, 28, 5, '中国人寿保险有限公司', '国寿福(盛典版)', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);
insert into product_info
values (product_series_id, 28, 5, '中国人寿保险有限公司', '国寿少儿国寿福(盛典版)产品', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00,
        1, 3,
        200, 0.0015, 3, pro_info_state);



insert into product_info
values (product_series_id, 29, 6, '中国人寿保险有限公司', '国寿鑫惠赢两全保险', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);
insert into product_info
values (product_series_id, 29, 6, '中国人寿保险有限公司', '国寿鑫裕尊享年金保险', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);
insert into product_info
values (product_series_id, 29, 6, '中国人寿保险有限公司', '国寿鑫裕年年年金保险', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);
insert into product_info
values (product_series_id, 29, 6, '中国人寿保险有限公司', '国寿鑫裕金生两财两全保险', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1,
        3,
        200, 0.0015, 3, pro_info_state);
insert into product_info
values (product_series_id, 29, 6, '中国人寿保险有限公司', '国寿鑫享福养老年金保险', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1,
        3,
        200, 0.0015, 3, pro_info_state);
insert into product_info
values (product_series_id, 29, 6, '中国人寿保险有限公司', '国寿鑫耀东方年金保险', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);
insert into product_info
values (product_series_id, 29, 6, '中国人寿保险有限公司', '国寿鑫福临门保险产品组合', 0.4150, 2, 20150619, 2, 0.002, 0.015, 2400.00, 1,
        3,
        200, 0.0015, 3, pro_info_state);
insert into product_info
values (product_series_id, 29, 6, '中国人寿保险有限公司', '国寿个人税收递延型养老年金保险(2018版)', 0.4150, 2, 20150619, 2, 0.002, 0.015,
        2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);



insert into product_info
values (product_series_id, 30, 7, '中国人寿保险有限公司', '国寿鑫享宝', 0.4150, 2, 20150619, 2, 0.002, 0.015,
        2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);
insert into product_info
values (product_series_id, 30, 7, '中国人寿保险有限公司', '国寿锦绣前程少儿两全保险', 0.4150, 2, 20150619, 2, 0.002, 0.015,
        2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);
insert into product_info
values (product_series_id, 30, 7, '中国人寿保险有限公司', '国寿鑫玉少儿年金保险(分红型)', 0.4150, 2, 20150619, 2, 0.002, 0.015,
        2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);



insert into product_info
values (product_series_id, 31, 8, '中国人寿保险有限公司', '国寿臻享传家终身保险', 0.4150, 2, 20150619, 2, 0.002, 0.015,
        2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);



insert into product_info
values (product_series_id, 32, 9, '中国人寿保险有限公司', '国寿如E康悦百万医疗保险(盛典版)', 0.4150, 2, 20150619, 2, 0.002, 0.015,
        2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);
insert into product_info
values (product_series_id, 32, 9, '中国人寿保险有限公司', '国寿附加特定疾病海外医疗保险', 0.4150, 2, 20150619, 2, 0.002, 0.015,
        2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);



insert into product_info
values (product_series_id, 33, 10, '中国人寿保险有限公司', '国寿百万如意行两全保险(盛典版)', 0.4150, 2, 20150619, 2, 0.002, 0.015,
        2400.00, 1, 3,
        200, 0.0015, 3, pro_info_state);


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
    audit_type         int(10) default 0 comment '产品审核状态',
    audit_state        int(10) default 1 comment '数据状态'
);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 2, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 3, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 4, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 5, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 6, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 7, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 8, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 9, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 10, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 11, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 12, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 13, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 14, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 15, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 16, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 17, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 18, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 19, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 20, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);
insert into product_audit
values (audit_id, 1, '小白', '通过', now(), now(), audit_type, audit_state);


-- 汇款信息表
drop table if exists remit_info;
create table remit_info
(
    remit_id           int(10) auto_increment comment '主键'
        primary key,
    product_series_id  int(10) comment '商品系列编号',
    rec_bank_name      varchar(50) comment '收款银行名称',
    swift_code         varchar(50) comment '银行国际代码',
    bank_code          varchar(50) comment '银行代码',
    cnaps_id           varchar(50) comment '人行系统支付号',
    rec_bank_area      varchar(255) comment '收款银行地区',
    rec_bank_city      varchar(100) comment '收款银行城市',
    rec_account_name   varchar(50) comment '收款人户名',
    rec_account        varchar(50) comment '收款人账号',
    rec_location       varchar(255) comment '收款人地址',
    regulate_body      varchar(50) comment '监管机构',
    remit_info_summary varchar(50) comment '汇款信息概略',
    remit_state        int(10) default 1 comment '收款状态'
);

-- 产品类型表
drop table if exists product_type;
create table financial_manage_sys.product_type
(
    product_series_id     int(10) auto_increment comment '产品分类编号'
        primary key,
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
values (product_series_id, 0, 2, '基金', 'fund', 0, product_type_state);
insert into product_type
values (product_series_id, 0, 2, '保险', 'insurance', 0, product_type_state);
insert into product_type
values (product_series_id, 0, 2, '证券', 'security', 0, product_type_state);


/**
  *******************************股票型*************************************
 */
insert into product_type
values (product_series_id, 1, 2, '富国中证煤炭指数(LOF)', 'LOF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '招商中证煤炭等权指数(LOF)', 'LOF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '国泰中证煤炭ETF联接', 'ETF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '中融中证煤炭指数', 'LOF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '创金合信红利低波动', 'LOF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '西部利得国企红利(LOF)', 'LOF', 1, product_type_state);


/**
  *******************************混合型*************************************
 */
insert into product_type
values (product_series_id, 1, 2, '万家宏观择时多策略混合', 'LOF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '万家新利灵活配置混合', 'LOF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '华夏饲料豆粕期货ETF联接', 'ETF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '万家精选混合', 'LOF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '招商稳健平衡混合', 'LOF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '景顺长城安鑫回报混合', 'LOF', 1, product_type_state);


/**
  *******************************债券型*************************************
 */
insert into product_type
values (product_series_id, 1, 2, '招商添浩纯债', 'LOF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '博时汇享纯债债券', 'LOF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '华泰紫金丰泰纯债发起', 'ETF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '永赢华嘉信用债', 'LOF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '长盛盛裕纯债', 'LOF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '光大岁末红利纯债', 'LOF', 1, product_type_state);


/**
  *******************************指数型*************************************
 */
insert into product_type
values (product_series_id, 1, 2, '广发中证基建工程ETF联接', 'LOF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '信诚中证基建工程指数(LOF)', 'LOF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '南方房地产ETF联接', 'ETF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '南方大盘红利50ETF联接', 'LOF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '招商沪深300地产等权重指数', 'LOF', 1, product_type_state);

insert into product_type
values (product_series_id, 1, 2, '广发中债7-10年国开债指数', 'LOF', 1, product_type_state);


/**
  ************************************保险系列************************************
 */

insert into product_type
values (product_series_id, 2, 2, '重疾保障', 'Disability Insurance', 1, product_type_state);



insert into product_type
values (product_series_id, 2, 2, '年金保险', 'Annuity Insurance', 1, product_type_state);



insert into product_type
values (product_series_id, 2, 2, '少儿/女性/养老保险', 'Children/Women/Endowment  Insurance', 1, product_type_state);



insert into product_type
values (product_series_id, 2, 2, '寿险保障', 'Life Insurance Guarantee', 1, product_type_state);



insert into product_type
values (product_series_id, 2, 2, '医疗保险', 'Medical Insurance', 1, product_type_state);



insert into product_type
values (product_series_id, 2, 2, '意外保障', 'Accident Insurance', 1, product_type_state);



/**
  ************************************证券系列************************************
 */


-- 产品类净值表
drop table if exists product_net_value;
create table product_net_value
(
    pro_net_value_id  int(10) primary key auto_increment comment '主键',
    product_id        int(10) comment '产品编号',
    unit_net          float(10, 4) comment '单位净值',
    unit_date         date comment '净值基准日',
    sum_increase_rate float(10, 4) comment '累计增长率',
    net_value_state   int(10) default 1 comment '净值状态'
);

insert into product_net_value
values (pro_net_value_id, 1, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 2, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 3, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 4, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 5, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 6, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 7, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 8, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 9, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 10, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 11, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 12, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 13, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 14, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 15, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 16, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 17, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 18, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 19, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 20, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 21, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 22, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 23, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 24, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 25, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 26, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 27, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 28, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 29, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 30, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 31, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 32, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 33, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 34, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 35, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 36, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 37, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 38, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 39, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 40, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 41, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 42, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 43, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 44, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 45, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 46, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 47, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 48, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 49, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 50, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 51, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 52, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 53, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 54, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 55, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 56, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 57, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 58, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 59, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 60, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 61, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 62, 1.8638, 20220518, 0.2638, net_value_state);
insert into product_net_value
values (pro_net_value_id, 63, 1.8638, 20220518, 0.2638, net_value_state);


-- 增加产品系列
insert into product_type
values (product_series_id, ?, ?, ?, ?, ?, 1, product_type_state);

update product_type,remit_info
set product_type_state = 0,
    remit_state= 0
where product_type.product_series_id = remit_info.product_series_id
  and product_type.product_series_id = ?;

select *
from product_type
where product_series_id = ?
  and product_type_state = 1;


-- 修改产品系列
update product_type
set product_parent_id     = ?,
    product_channel       = ?,
    product_type_ch_name  = ?,
    product_type_eng_name = ?,
    product_type_state    = ?
where product_series_id = ?;

-- 修改汇款信息
update remit_info
set rec_bank_name      = ?,
    swift_code         = ?,
    bank_code          = ?,
    cnaps_id           = ?,
    rec_bank_area      = ?,
    rec_bank_city      = ?,
    rec_account_name   = ?,
    rec_account        = ?,
    rec_location       = ?,
    regulate_body      = ?,
    remit_info_summary = ?,
    remit_state        = ?
where product_series_id = ?;

select *
from product_type
order by product_series_id desc
limit 1;

select count(product_type.product_series_id)
from product_type,
     remit_info
where product_type.product_series_id = remit_info.product_series_id
  and product_type.product_type_state = 1
  and remit_state = 1
  and product_type.product_series_id like '%?%'
  and product_type_ch_name like '%?%';


select product_type.product_series_id,
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
       rec_location,
       regulate_body
from product_type,
     remit_info
where product_type.product_series_id = remit_info.product_series_id
  and product_type.product_type_state = 1
  and remit_state = 1
  and product_type.product_series_id like '%1%'
limit ?,?;

-- 增加汇款信息
insert into remit_info
values (remit_id, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, remit_state);

-- 更新汇款信息
update product_type
set product_parent_id     = ?,
    product_channel       = ?,
    product_type_ch_name  = ?,
    product_type_eng_name = ?,
    product_type_state    = ?
where product_series_id = ?
  and product_type_state = 1;

update remit_info
set rec_bank_name      = ?,
    swift_code         = ?,
    bank_code          = ?,
    cnaps_id           = ?,
    rec_bank_area= ?,
    rec_bank_city= ?,
    rec_account_name   = ?,
    rec_account        = ?,
    rec_location       = ?,
    regulate_body= ?,
    remit_info_summary = ?,
    remit_state=?
where product_series_id = ?
  and remit_state = 1;


select product_info.product_id,
       product_ch_name,
       product_type_ch_name,
       sec_name,
       regulate_body,
       open_time,
       currency_type,
       audit_type,
       unit_net,
       unit_date,
       sum_increase_rate,
       annual_yield,
       sub_cycle,
       fund_manage_fee_rate,
       sub_rate,
       init_invest_amount,
       sub_fee_collect_method,
       red_cycle,
       red_init_amount,
       red_amount,
       lock_period,
       auditor
from product_info,
     product_audit,
     product_net_value,
     product_type,
     product_second_type
where product_info.product_id = product_audit.product_id
  and product_info.product_series_id = product_type.product_series_id
  and product_info.product_id = product_audit.product_id
  and product_info.sec_id = product_second_type.sec_id
  and audit_state = 1
  and pro_info_state = 1
  and net_value_state = 1
  and audit_state = 1
  and product_ch_name like '%?%'
  and product_info.sec_id = ?
  and audit_type = ?
group by product_id
limit ?,?;


select count(*)
from (select product_info.product_id,
             product_ch_name,
             product_type_ch_name,
             sec_name,
             regulate_body,
             open_time,
             currency_type,
             audit_type,
             unit_net,
             unit_date,
             sum_increase_rate,
             annual_yield,
             sub_cycle,
             fund_manage_fee_rate,
             sub_rate,
             init_invest_amount,
             sub_fee_collect_method,
             red_cycle,
             red_init_amount,
             red_amount,
             lock_period,
             auditor
      from product_info,
           product_audit,
           product_net_value,
           product_type,
           product_second_type
      where product_info.product_id = product_audit.product_id
        and product_info.product_series_id = product_type.product_series_id
        and product_info.product_id = product_audit.product_id
        and product_info.sec_id = product_second_type.sec_id
        and audit_state = 1
        and pro_info_state = 1
        and net_value_state = 1
        and audit_state = 1
        and product_ch_name like '%?%'
        and product_info.sec_id = ?
        and audit_type = ?
      group by product_id
      limit ?,?) as pipa;



update product_info,product_second_type,product_audit
set product_series_id      = ?,
    sec_id                 = ?,
    regulate_body          = ?,
    product_ch_name        = ?,
    annual_yield           = ?,
    currency_type          = ?,
    open_time              = ?,
    sub_cycle              = ?,
    fund_manage_fee_rate   = ?,
    sub_rate               = ?,
    init_invest_amount     = ?,
    sub_fee_collect_method = ?,
    red_cycle              = ?,
    red_init_amount        = ?,
    red_amount             = ?,
    lock_period            = ?,
    pro_info_state         = ?,
    auditor                = ?
where product_info.product_id = product_audit.product_id
  and pro_info_state = 1
  and audit_state = 1;

update product_net_value
set unit_net          = ?,
    unit_date         = ?,
    sum_increase_rate = ?,
    net_value_state   = ?
where product_id = ?;


select product_type_ch_name from product_type where

update product_info,product_net_value,product_audit
set pro_info_state  = 0,
    net_value_state = 0,
    audit_state     = 0
where product_info.product_id = product_net_value.product_id
  and product_info.product_id = product_audit.product_id
  and product_info.product_id = 1;


-- 产品
drop table if exists product_second_type;
create table product_second_type
(
    sec_id            int(10) primary key auto_increment comment '主键',
    product_series_id int(10) comment '产品系列编号',
    sec_name          varchar(50) comment '二级分类名称'
);
insert into product_second_type
values (sec_id, 1, '股票基金');
insert into product_second_type
values (sec_id, 1, '混合型基金');
insert into product_second_type
values (sec_id, 1, '债券型基金');
insert into product_second_type
values (sec_id, 1, '指数型基金');

insert into product_second_type
values (sec_id, 2, '重疾保障');
insert into product_second_type
values (sec_id, 2, '年金保险');
insert into product_second_type
values (sec_id, 2, '少儿/女性/养老保险');

insert into product_second_type
values (sec_id, 2, '寿险保障');
insert into product_second_type
values (sec_id, 2, '医疗保险');
insert into product_second_type
values (sec_id, 2, '意外保障');

select sec_name
from product_second_type;


select product_type_ch_name from product_type where product_type_lv = 1 and product_type_state = 1;