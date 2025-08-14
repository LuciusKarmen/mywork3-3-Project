
export interface Branch {
  id: number; // 部门编号
  name: string; // 部门名称
  manager: string; // 部门经理
  phone: string; // 部门电话
  email: string; // 部门邮箱
  number: number; // 部门人数
  top: string; // 部门上级(XXX/公司直属)
  date: string; // 部门成立时间
  description: string; // 职责描述
}

export const branches: Branch[] = [
  {
    id: 1,
    name: '开发部',
    manager: '李伟',
    phone: '010-88888801',
    email: 'dev@company.com',
    number: 8,
    top: '公司直属',
    date: '2020-01-15',
    description: '负责公司所有前后端系统的开发、架构设计与技术攻关',
  },
  {
    id: 2,
    name: '设计部',
    manager: '王芳',
    phone: '010-88888802',
    email: 'design@company.com',
    number: 4,
    top: '公司直属',
    date: '2020-03-20',
    description: '负责产品UI/UX设计、品牌视觉、宣传物料制作',
  },
  {
    id: 3,
    name: '测试部',
    manager: '张强',
    phone: '010-88888803',
    email: 'qa@company.com',
    number: 2,
    top: '公司直属',
    date: '2021-05-10',
    description: '负责产品质量保障、功能测试、自动化测试与性能测试',
  },
  {
    id: 4,
    name: '人事部',
    manager: '陈静',
    phone: '010-88888804',
    email: 'hr@company.com',
    number: 2,
    top: '公司直属',
    date: '2019-08-01',
    description: '负责招聘、培训、薪酬福利、员工关系与组织发展',
  },
  {
    id: 5,
    name: '销售部',
    manager: '赵敏',
    phone: '010-88888805',
    email: 'sales@company.com',
    number: 3,
    top: '公司直属',
    date: '2019-11-11',
    description: '负责客户开发、合同签订、销售目标达成与客户维护',
  },
  {
    id: 6,
    name: '运维部',
    manager: '吴磊',
    phone: '010-88888806',
    email: 'ops@company.com',
    number: 3,
    top: '公司直属',
    date: '2020-07-22',
    description: '负责服务器部署、系统监控、网络安全与故障应急响应',
  },
  {
    id: 7,
    name: '产品部',
    manager: '周涛',
    phone: '010-88888807',
    email: 'product@company.com',
    number: 2,
    top: '公司直属',
    date: '2022-01-05',
    description: '负责产品规划、需求分析、原型设计与版本迭代管理',
  },
  {
    id: 8,
    name: '财务部',
    manager: '徐丽',
    phone: '010-88888808',
    email: 'finance@company.com',
    number: 3,
    top: '公司直属',
    date: '2019-06-18',
    description: '负责公司账务处理、成本控制、税务申报与财务分析',
  },
  {
    id: 9,
    name: '行政部',
    manager: '黄娟',
    phone: '010-88888809',
    email: 'admin@company.com',
    number: 2,
    top: '公司直属',
    date: '2020-02-14',
    description: '负责办公管理、后勤支持、物资采购与企业文化建设',
  },
  {
    id: 10,
    name: '市场部',
    manager: '马超',
    phone: '010-88888810',
    email: 'marketing@company.com',
    number: 2,
    top: '公司直属',
    date: '2021-09-09',
    description: '负责品牌推广、市场活动、渠道合作与用户增长',
  },
];