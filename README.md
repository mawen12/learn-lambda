# Lamdba

## 函数式编程

- 面向对象编程是对数据进行抽象
- 函数式编程是对行为进行抽象
    - 易读
    - 易维护
    - 可靠
    - 容错
    - 延迟初始化

## Stream

- 内部迭代
- 操作 - 类似于建造者模式
  - 惰性求值 - 方法返回值Stream，用于刻画描述Stream
  - 及早求值 - 产生指定值

### 常见操作

- collect(toList())
- 