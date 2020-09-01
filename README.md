## 간단한 코딩 테스트

어떤 Library를 사용 할 일이 생겼습니다.  

```
TestLibrary lib = new TestLibrary();
```
두개의 함수를 순서대로 실행해주어야 합니다.

firstTask는 callback으로 결과를 주는 함수이고,  
sendTask는 firstTask의 결과값을 필요로 합니다.  

```java
public class Main {
	public static void main(String[] args) {
		String result = tasks();
		System.out.println(result);
	}

	private static String tasks(){
		TestLibrary lib = new TestLibrary();

		final String[] result = new String[1];

		lib.firstTask(new Task() {
			@Override
			public void taskCallback(String s) {
				 result[0] = lib.secondTask(s);
			}
		});

		// FIXME always null.
		return result[0];
	}
}
```
그런데, 생각했던대로 동작하지 않네요...

tasks함수가 lib.secondTask() 함수의 값을 잘 반환할 수 있도록 수정해 주세요!
