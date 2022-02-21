大纲结构参考了[《计算机程序设计艺术》](https://www-cs-faculty.stanford.edu/~knuth/taocp.html)系列书，该书专注计算机经典的领域问题，是享誉盛名的算法分析书籍。遇到算法和数据结构问题时，可归到该书范畴内的内容，一律放在这个目录下。
大
在编写庞大复杂的程序时，往往聚焦于某些关键算法，这些算法消耗了大多数的系统资源，因此研究和学习与其相关的基础算法是非常必要的。本章节主要学习和分析那些应用广泛的基础算法。

> 作者计划，整套书共有7卷，其总目录如下：
>
> 第1卷 基本算法（Vol 1: Fundamental Algorithms）
>
> --第1章 基本概念（Chapter 1: Basic Concepts）
>
> --第2章 信息结构（Chapter 2: Information Structures）
>
> 第2卷 半数值算法（Vol 2: Seminumerial Algorithms）
>
> --第3章 随机数（Chapter 3: Random Numbers）
>
> --第4章 算术（Chapter 4: Arithmetic）
>
> 第3卷 排序与查找（Vol 3: Sorting and Searching）
>
> --第5章 排序 （Chapter 5: Sorting）
>
> --第6章 查找（Chapter 6: Searching）
>
> 第4卷 组合算法（Vol 4: Combinatorial Algorithms）
>
> --第7章 组合检索（Chapter 7: Combinatorial Searching）
>
> --第8章 递归（Chapter 8: Recursion）
>
> 第5卷 语法算法（Vol 5: Syntactic Algorithms）
>
> --第9章 词法扫描（Chapter 9: Lexical Scanning）
>
> --第10章 语法分析（Chapter 10: Parsing Sechniques）
>
> 有关专门课题的另外两卷还在准备中：第6卷语言理论（The Theory of Context-free Languages）（第11章）和第7卷编译程序（Compiler Techniques）（第12章）。

```
Chapter 1 Basic Concepts 1
    1.1. Algorithms 　1
    1.2. Mathematical Preliminaries 　 10
        1.2.1. Mathematical Induction 　11
        1.2.2. Numbers, Powers, and Logarithms 　21
        1.2.3. Sums and Products 　 27
        1.2.4. Integer Functions and Elementary Number Theory 　 39
        1.2.5. Permutations and Factorials 　 45
        1.2.6. Binomial Coefficients 　 52
        1.2.7. Harmonic Numbers 　 75
        1.2.8. Fibonacci Numbers 　 79
        1.2.9. Generating Functions 　87
        1.2.10. Analysis of an Algorithm 　96
        *1.2.11. Asymptotic Representations 　 107
			*1.2.11.1. The O-notation . 107
            * 1.2.11.2. Euler's summation formula 　 111
            * 1.2.11.3. Some asymptotic calculations 　 116
	1.3. MIX 　124
        1.3.1. Description of MIX 　 124
        1.3.2. The NIX Assembly Language 　 144
        1.3.3. Applications to Permutations 　164
	1.4. Some Fundamental Programming Techniques 　180
        1.4.1. Subroutines 　 180
        1.4.2. Coroutines 　193
        1.4.3. Interpretive Routines 　 200
            1.4.3.1. A NIX simulator 　202
            "1.4.3.2. Trace routines 　 212
        1.4.4. Input and Output 　 215
        1.4.5. History and Bibliography 　 229
Chapter 2 Information Structures 　 232
    2.1. Introduction 　 232
    2.2. Linear Lists 　238
        2.2.1. Stacks, Queues, and Deques 　238
        2.2.2. Sequential Allocation 　244
        2.2.3. Linked Allocation 　 254
        2.2.4. Circular Lists 　273
        2.2.5. Doubly Linked Lists 　 280
        2.2.6. Arrays and Orthogonal Lists 　 298
	2.3. Trees 308
	　　2.3.1. Traversing Binary Trees 318
	　　2.3.2. Binary Tree Representation of Trees 　334
	　　2.3.3. Other Representations of Trees 　 348
	　　2.3.4. Basic Mathematical Properties of Trees 　362
		　　2.3.4.1. Free trees 　363
		　　2.3.4.2. Oriented trees 　372
		　　*2.3.4.3. The "infinity lemma" 　382
		　　*2.3.4.4. Enumeration of trees 　386
		　　2.3.4.5. Path length 　399
		　　*2.3.4.6. History and bibliography 　406
		　　2.3.5. Lists and Garbage Collection 408
　　2.4. Multilinked Structures 　424
　　2.5. Dynamic Storage Allocation 　 435
　　2.6. History and Bibliography 　 457
Chapter 3 Random Numbers 1
　　3.1. Introduction　1
　　3.2. Generating Uniform Random Numbers 10
	　　3.2.1. The Linear Congruential Method 10
		　　3.2.1.1. Choice of modulus 12
		　　3.2.1.2. Choice of multiplier 16
		　　3.2.1.3. Potency 23
	　　3.2.2. Other Methods 26
　　3.3. Statistical Tests 41
	　　3.3.1. General Test Procedures for Studying Random Data 42
	　　3.3.2. Empirical Tests 61
	　　*3.3.3. Theoretical Tests80
	　　3.3.4. The Spectral Test 93
　　3.4. Other Types of Random Quantities 119
	　　3.4.1. Numerical Distributions 119
	　　3.4.2. Random Sampling and Shuffling 142
　　*3.5. What Is a Random Sequence?　 149
　　3.6. Summary　 184
Chapter 4 Arithmetic　 194
　　4.1. Positional Number Systems　 195
　　4.2. Floating Point Arithmetic　 214
	　　4.2.1. Single-Precision Calculations 214
	　　4.2.2. Accuracy of Floating Point Arithmetic 229
	　　*4.2.3. Double-Precision Calculations 246
	　　4.2.4. Distribution of Floating Point Numbers 253
　　4.3. Multiple Precision Arithmetic 265
	　　4.3.1. The Classical Algorithms 265
	　　*4.3.2. Modular Arithmetic 284
	　　*4.3.3. How Fast Can We Multiply? 294
　　4.4. Radix Conversion 319
　　4.5. Rational Arithmetic 330
	　　4.5.1. Fractions 330
	　　4.5.2. The Greatest Common Divisor 333
	　　*4.5.3. Analysis of Euclid's Algorithm 356
	　　4.5.4. Factoring into Primes 379
　　4.6. Polynomial Arithmetic　 418
	　　4.6.1. Division of Polynomials 420
	　　*4.6.2. Factorization of Polynomials 439
	　　4.6.3. Evaluation of Powers 461
	　　4.6.4. Evaluation of Polynomials 485
　　*4.7. Manipulation of Power Series　525
Chapter 5 Sorting 1
	*5.1. Combinatorial Properties of Permutations 11
	　　*5.1.1. Inversions　11
	　　*5.1.2. Permutations of a Multiset　22
	　　*5.1.3. Runs　35
	　　*5.1.4. Tableaux and Involutions　 47
	5.2. Internal sorting　73
	　　5.2.1. Sorting by Insertion　80
	　　5.2.2. Sorting by Exchanging　105
	　　5.2.3. Sorting by Selection　138
	　　5.2.4. Sorting by Merging　158
	　　5.2.5. Sorting by Distribution　168
	5.3. Optimum Sorting 180
	　　5.3.1. Minimum-Comparison Sorting　 180
	　　*5.3.2. Minimum-Comparison Merging　 197
	　　*5.3.3. Minimum-Comparison Selection　207
	　　*5.3.4. Networks for Sorting　219
	5.4. External Sorting　248
	　　5.4.1. Multiway Merging and Replacement Selection　 252
	　　*5.4.2. The Polyphase Merge　267
	　　*5.4.3. The Cascade Merge　288
	　　*5.4.4. Reading Tape Backwards　 299
	　　*5.4.5. The Oscillating Sort 　 311
	　　*5.4.6. Practical Considerations for Tape Merging　317
	　　*5.4.7. External Radix Sorting　343
	　　*5.4.8. Two-Tape Sorting　348
	　　*5.4.9. Disks and Drums356
　　5.5. Summary, History, and Bibliography　 380
Chapter 6 Searching　392
	6.1. Sequential Searching 　 396
	6.2. Searching by Comparison of Keys　 409
	　	6.2.1. Searching an Ordered Table　 409
	　　6.2.2. Binary Tree Searching　 426
	　　6.2.3. Balanced Trees　 458
	　　6.2.4. Multiway Trees 　481
	6.3. Digital Searching 492
	6.4. Hashing　513
	6.5. Retrieval on Secondary Keys　559
Chapter 7—Combinatorial Searching
	7.1.　Zeros and Ones
		7.1.1.　Boolean Basice
		7.1.2.　Boolean Evaluation
		7.1.3　 Bitwise Tricks and Techniques
		7.1.4.　Binary Decision Diagrams
	7.2.　Generating All Possibilities
		7.2.1.　Generating Basic Combinatorial Patterns
			7.2.1.1.　Generating all n-tuples
			7.2.1.2.　Generating all permutations
			7.2.1.3.　Generating all combinations
			7.2.1.4.　Generating all partitions
			7.2.1.5.　Generating all set partitions
			7.2.1.6.　Generating all trees
		7.2.2. Basic backtrack
		7.2.2. Backtrack programming
			7.2.2.1. Dancing links
			7.2.2.2. Satisfiability
			7.2.2.3. Constraint satisfaction
			7.2.2.4. Hamiltonian paths and cycles
			7.2.2.5. Cliques
			7.2.2.6. Covers
			7.2.2.7. Squares
			7.2.2.8. A potpourri of puzzles
			7.2.2.9. Estimating backtrack costs
		7.2.3. Generating inequivalent patterns
	7.3. Shortest paths
	7.4. Graph algorithms
		7.4.1. Components and traversal
		7.4.2. Special classes of graphs
		7.4.3. Expander graphs
		7.4.4. Random graphs
	7.5. Network algorithms
		7.5.1. Distinct representatives
		7.5.2. The assignment problem
		7.5.3. Network flows
		7.5.4. Optimum subtrees
		7.5.5. Optimum matching
		7.5.6. Optimum orderings
	7.6. Independence theory
		7.6.1. Independence structures
		7.6.2. Efficient matroid algorithms
	7.7. Discrete dynamic programming
	7.8. Branch-and-bound techniques
	7.9. Herculean tasks (aka NP-hard problems)
	7.10. Near-optimization
```



```
第1章基本概念1
1.1算法.1
1.2数学准备.8
1.2.1数学归纳法.8
1.2.2数、幂和对数16
1.2.3和与积.21
1.2.4整数函数与初等数论30
1.2.5排列与阶乘.35
1.2.6二项式系数.41
1.2.7调和数.59
1.2.8斐波那契数.62
1.2.9生成函数69
1.2.10典型算法分析76
*1.2.11渐近表示85
*1.2.11.1大O记号85
*1.2.11.2欧拉求和公式.88
*1.2.11.3若干渐近计算式92
1.3MIX99
1.3.1MIX的描述99
1.3.2MIX汇编语言.116
1.3.3排列的应用.131
1.4若干基本程序设计技术150
1.4.1子程序.150
1.4.2协同程序155
1.4.3解释程序161
1.4.3.1MIX模拟程序.162
*1.4.3.2追踪程序171
1.4.4输入与输出.173
1.4.5历史和参考文献.184
第2章信息结构187
2.1引论.187
2.2线性表191
2.2.1栈、队列和双端队列191
2.2.2顺序分配195
2.2.3链接分配203
2.2.4循环链表217
2.2.5双链表.222
2.2.6数组与正交表237
2.3树245
2.3.1遍历二叉树.253
2.3.2树的二叉树表示.265
2.3.3树的其他表示276
2.3.4树的基本数学性质.287
2.3.4.1自由树.287
2.3.4.2定向树.294
*2.3.4.3无限性引理.301
*2.3.4.4树的枚举304
2.3.4.5路径长度314
*2.3.4.6历史和参考文献320
2.3.5表和垃圾回收322
2.4多链结构.333
2.5动态存储分配.342
第3 章随机数 1
3.1.　引言　1
3.2.　生成均匀的随机数　8
3.2.1.　线性同余法　8
3.2.1.1.　模的选择　9
3.2.1.2.　乘数的选择　13
3.2.1.3.　势　18
3.2.2.　其他方法　20
3.3.　统计检验　32
3.3.1.　研究随机数据的一般检验过程　32
3.3.2.　经验检验　46
*3.3.3.　理论检验　60
3.3.4.　谱检验　70
3.4.　其他类型的随机量　90
3.4.1.　数值分布　90
3.4.2.　随机抽样和洗牌　107
*3.5.　什么是随机序列？　113
3.6.　小结　139
第4　章算术　147
4.1.　按位记数系统　147
4.2.　浮点算术　163
4.2.1.　单精度计算　163
4.2.2.　浮点算术的精度　175
*4.2.3.　双精度计算　188
4.2.4.　浮点数的分布　194
4.3.　多精度算术　203
4.3.1.　经典算法　203
*4.3.2.　模算术　218
*4.3.3.　乘法有多快？　225
4.4.　进制转换　245
4.5.　有理数算术　254
4.5.1.　分数　254
4.5.2.　最大公因数　256
*4.5.3.　对欧几里得算法的分析 . .　274
4.5.4.　分解素因数　293
4.6.　多项式算术　324
4.6.1.　多项式除法　325
*4.6.2.　多项式的因子分解　340
4.6.3.　幂的计算　358
4.6.4.　多项式求值　378
*4.7.　对幂级数的操作　409
第5章　排序　　1
*5.1　排序的组合性质　　8
*5.1.1　反序　　8
*5.1.2　多重集的排列　　16
*5.1.3　游程　　26
*5.1.4　图表与对合　　36
5.2　内部排序　　56
5.2.1　插入排序　　61
5.2.2　交换排序　　81
5.2.3　选择排序　　107
5.2.4　合并排序　　123
5.2.5　分布排序　　131
5.3　最优排序　　140
5.3.1　比较次数最少的排序　　140
*5.3.2　比较次数最少的合并　　153
*5.3.3　比较次数最少的选择　　161
*5.3.4　排序网络　　171
5.4　外部排序　　194
5.4.1　多路合并和替代选择　　197
*5.4.2　多阶段合并　　208
*5.4.3　级联合并　　226
*5.4.4　反向读取磁带　　235
*5.4.5　振荡排序　　245
*5.4.6　磁带合并的实践考虑　　250
*5.4.7　外部基数排序　　269
*5.4.8　双磁带排序　　273
*5.4.9　磁盘与磁鼓　　279
5.5　小结、历史与文献　　297
第6章　查找　　306
6.1　顺序查找　　308
6.2　通过键的比较进行查找　　318
6.2.1　查找有序表　　318
6.2.2　二叉树查找　　332
6.2.3　平衡树　　358
6.2.4　多路树　　376
6.3　数字查找　　385
6.4　散列　　402
6.5　辅助键的查找　　437
第7 章组合查找 1
7．1 0 与1 38
7．1．1 布尔代数基础 38
7．1．2 布尔函数求值 79
7．1．3 按位运算的技巧与方法 110
7．1．4 二元决策图 170
7．2 生成所有可能的组合对象 237
7．2．1 生成基本组合模式 237
7．2．1．1 生成所有n 元组 237
7．2．1．2 生成所有排列 268
7．2．1．3 生成所有组合 297
7．2．1．4 生成所有分划 327
7．2．1．5 生成所有集合分划 349
7．2．1．6 生成所有树 370
7．2．1．7 历史与扩展文献 408
```


