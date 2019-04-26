### 单列模式

   即一个类无论实例化多少个，其实都是一样的，而且更重要的一点是:这个类如果如果有两个或两个以上的实例，
程序会产生程序错误或者与现实想违背的逻辑错误。
    
#### 第一种方式
我们来看一下最标准也是最原始的单例模式的构造方式
[代码地址](https://github.com/Huanglog/design-pattern/blob/master/singleton/src/main/java/com.singleton/Singleton.java)
    
这是在不考虑并发的情况下标准的单例模式的构造方法，这种方式通过几个地方来限制了我们取到实例的唯一的。
1. 静态实例，带有static关键字的属性在每一个类中都是唯一的。
2. 限制客户端随意创造实例，即私有化构造方法，此为保证单例的最重要的一步。
3. 给一个公共的获取实例的静态方法，注意，是静态的方法，因为这个方法是在我们未获取到实例的时候就要
    提供给客户端调用的，所以如果是非静态的话，那就变成一个矛盾体了，因为非静态的方法必须要拥有实例才可以调用。
4. 判断只有持有的静态实例为null时才调用构造方法创造一个实例，否则就直接返回。

造成这种情况的原因是因为，当并发访问的时候，第一个第一个调用getInstance方法的线程A，在判断完singleton是null的时候，线程A就进入了if块准备创造实例，
但是同时另外一个线程B在线程A还未创造出实例之前，就又进行了singleton是否为null的判断，这时singleton依然为null，所以线程B也会进入if块去创造实例，
这时问题就出来了，有两个线程都进入了if块去创造实例，结果就造成单例模式并非单例
 
 为了避免这种情况，我们就要考虑并发的情况，最容易想到的就是加关键字：synchronized。[代码地址](https://github.com/Huanglog/design-pattern/blob/master/singleton/src/main/java/com.singleton/SynchronizedSingleton.java)
 
 这样的做法很简单，就是将整个获取实例的方法同步，这样在一个线程访问此方法时，其他所有线程就挂起。显然这样的设计不符合我们的对代码的追求，
 表现出来的性能糟糕透了。
 
 其实我们同步的地方只需要发生在实例还未创建的时候，在实例创建后，我们就没必要再进行同步控制。可以使用一种更优雅的编码方式，
 也是大家看得最多的例子。**双重加锁**，即**Double Check Lock(DCL)**,[代码地址](https://github.com/Huanglog/design-pattern/blob/master/singleton/src/main/java/com.singleton/DCLSingleton.java)
 
 这种做法比上面的做法要好得多。因为我们只是在当前实例为null，也就是实例还未创建时同步，否则就直接返回已创建实例。
 