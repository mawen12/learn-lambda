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
- map
- filter
- flatMap
- max
- min
- reduce

### 优化1

链式调用：
- 使用链式调用，可以提升可读性、降低样板代码、暴露真正的业务逻辑
- 只在必要时才进行及早求值，提升效率
- 无需中间变量
- 允许并行化

### OOP优化

面向对象编程的核心之一就是封装局部状态，即外部代码不查看非相关对象的状态，只需要传递行为，由对象内部自己检查

