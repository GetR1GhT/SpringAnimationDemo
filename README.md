# Android开发利用SpringAnimation实现弹性动画

 &nbsp;&nbsp;&nbsp;&nbsp;在最近更新的25.3.0的支持库中，新更新了一个叫做DynamicAnimation（动力学动画？？）的类，其中他有一个子类叫做SpringAnimation，官方文档是这样说的：
	  
	This class is the base class of physics-based animations.
	It manages the animation's lifecycle such as start() and cancel().
	This base class also handles the common setup for all the subclass animations.
	For example, DynamicAnimation supports adding DynamicAnimation.OnAnimationEndListener and   DynamicAnimation.OnAnimationUpdateListener so that the important animation events can be observed through the callbacks. 
	The start conditions for any subclass of DynamicAnimation can be set using setStartValue(float) and setStartVelocity(float).
	
粗略的翻译一下：
		 这个类是基于物理学动画的鸡肋，能够管理动画的生命周期，例如start()和cancel()，同时还能处理所有子类动画的常用设置。
		 举个简单的栗子，DynamicAnimation支持添加DynamicAnimation.OnAnimationEndListener 和DynamicAnimation.OnAnimationUpdateListener这种可以观察到重要的动画事件的回调，任何子类DynamicAnimation可以使用setStartValue(float)和setStartVelocity(float)设置初始条件。
		  那么也就是说我们可以通过这个新更新出来的动画库来实现一些更加符合物理学的动画。

##SpringAnimation简介

上面已经介绍了SpringAnimation的父类，那么这个SpringAnimation又是个什么鬼呢？春天动画？并不是，而是弹性动画。官方文档是这样说的：
 
		SpringAnimation is an animation that is driven by a SpringForce. The spring force defines the spring's stiffness, damping ratio, as well as the rest position. Once the SpringAnimation is started, on each frame the spring force will update the animation's value and velocity. The animation will continue to run until the spring force reaches equilibrium. If the spring used in the animation is undamped, the animation will never reach equilibrium. Instead, it will oscillate forever.
		
		SpringAnimation是一种由SpringForce驱动的动画。 弹力定义了弹簧的刚度,阻尼比,以及静止位置。一旦SpringAnimation开始,每一帧中，弹力将更新动画的值和速度。直到弹力达到平衡前，动画将持续运行。如果动画没有阻尼,动画将永远不会达到平衡。相反,它会一直弹。
				
介绍完毕，那我们就来创建一个最简单的SpringAnimation。

##使用SpringAnimation
	
1.引包
	

```
compile 'com.android.support:support-dynamic-animation:25.3.1'
```
2.创建默认的SpringAnimation

```
 new SpringAnimation(view, DynamicAnimation.TRANSLATION_X, 1f)
                        .setSpring(new SpringForce())
                        .setStartValue(0)
                        .setStartVelocity(5000).start();

```
这就搞定了，这里面第一个参数是释放动画的view，第二个参数是动画类型，第三个是float类型的被作用对象最终位置。

3.预先设置SpringForce来驱动动画

```
//在0位置设置一个低刚度，低弹力的SpringForce

                SpringForce spring = new SpringForce(0)
                     .setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY)
                     .setStiffness(SpringForce.STIFFNESS_LOW);
                     
                new SpringAnimation(view, DynamicAnimation.SCALE_Y)
                        .setMinValue(0).setSpring(spring).setStartValue(1).start();
       
```

setDampingRatio（@FloatRange(from = 0.0) float dampingRatio）是用来设置阻尼的，这个参数不能够小于0，否则会报错。当它的值是0的时候 ，动画就会不停的弹，当值大于1的时候，动画靠近原位置的时候提前减速后停止，如果当它的值是1的时候，动画就不会弹了，其中官方在SpringForce类中给了这么几个常量：

```
public static final float DAMPING_RATIO_HIGH_BOUNCY = 0.2f;
 /*
  * 这个是默认值
  */
public static final float DAMPING_RATIO_MEDIUM_BOUNCY = 0.5f;
 
public static final float DAMPING_RATIO_LOW_BOUNCY = 0.75f;
 
public static final float DAMPING_RATIO_NO_BOUNCY = 1f;
```
可以直接SpringForce.DAMPING_RATIO_HIGH_BOUNCY这样使用，也可以自己填0.3f这样的具体数值。

setStiffness(@FloatRange(from = 0.0) float stiffness)是用来设置刚度的，同样不能小于0，它的值越小，弹性越强，弹的时间越长，反之弹的时间越短，在SpringForce类中定义了这样几个常量：

```
    public static final float STIFFNESS_HIGH = 10_000f;
    /*
	 * 这个是默认值
     */
    public static final float STIFFNESS_MEDIUM = 1500f;
   
    public static final float STIFFNESS_LOW = 200f;
    
    public static final float STIFFNESS_VERY_LOW = 50f;
```
4.构造方法

SpringAnimation有两种构造方法

- public SpringAnimation(View v, ViewProperty property)

- public SpringAnimation(View v, ViewProperty property, float finalPosition)

如果使用三个参数的方法就可以不用设置SpringForce

```
SpringAnimation anim = new SpringAnimation(view ,DynamicAnimation.ROTATION,0);
anim.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
anim.getSpring().setStiffness(SpringForce.STIFFNESS_VERY_LOW);
anim.start();
```
而是这样的方式来使用。

5.设置起始位置和速度

- 起始位置

```
setStartValue(float startValue)
```

SpringForce设置了view的终点，但是我们需要使用SpringAnimation的setStartValue(float startValue) 来设置动画的开始位置，如果不使用这个方法，那么动画就会吧view的当前位置当做起始点。

- 起始速度

```
setStartVelocity(float startVelocity)
```

SpringAnimation的默认起始速度是0，我们可以自己定义动画的起始速度, 这个速度的值是 像素/秒。
