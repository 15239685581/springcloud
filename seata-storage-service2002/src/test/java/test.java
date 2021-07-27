import java.util.UUID;

public class test
{
    public static void main(String[] args) {
        //uuid(universally Unique identifier)的标准形式包含32个16进制数字，以连字号分为五段，形式为8-4-4-4-12的36个字符，示例：
        //性能非常高。本地生成，没有网络消耗
        System.out.println(UUID.randomUUID().toString());

    }
}
