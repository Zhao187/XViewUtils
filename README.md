
<h1 align="center">Welcome to XViewUtils 👋</h1>

### 🏠 [Homepage](https://jitpack.io/#Zhao187/XViewUtils/1.0.0)
### ✨ [Demo](https://github.com/Zhao187/XViewUtils/)
## Install

```groovy
Step 1. Add the JitPack repository to your build file
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency
dependencies {
	 implementation 'com.github.Zhao187:XViewUtils:Tag'
}
```
## Usage

```java
   @ViewInject(R.id.tv_title)
    TextView tvTitle;
    
   //注入界面
   XViewUtils.instance().inject(this);
   
    @OnClick(R.id.btn_fragemt)
    public void onFragmentClick(View view)
    {
      
    }
 //View注入
  XViewUtils.instance().inject(view);
  
 //Fragment注入
  XViewUtils.instance().inject(this);
```


## Author

👤 **赵宏图**

* 个人博客: http://39.106.130.249:8088/blog/
* GitHub: [Steven.zhao](https://github.com/Zhao187)
* 码云:https://gitee.com/zhao187

## 🤝 Contributing

Contributions, issues and feature requests are welcome!<br />Feel free to check `You can also take a look at the [contributing guide]

## Show your support

Give a ⭐️ if this project helped you!


## 📝 License

Steven.zhao && Zhao187
Copyright © 2019 [Zhao187](https://github.com/Zhao187).<br />

