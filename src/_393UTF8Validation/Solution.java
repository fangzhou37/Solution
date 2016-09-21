package _393UTF8Validation;

public class Solution {
    // 0000 0000-0000 007F | 0xxxxxxx
    // 0000 0080-0000 07FF | 110xxxxx 10xxxxxx
    // 0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
    // 0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
    public boolean validUtf8(int[] data) {
        int byteCount = 0;
        if (data[0] < 0) {
            return true;
        }
        int start = 0;
        while (start < data.length) {
            if (data[start] <= 128) {
                // 128 = 0x01111111
                start++;
                continue;
            } else if (data[start] >= 192 && data[start] <= 223 && start + 1 < data.length) {
                // 192 = 11000000;  223 = 11011111
                if (data[start + 1] >= 128 && data[start + 1] < 192) {
                    start += 2;
                    continue;
                }
            } else if (data[start] >= 224 && data[start] <= 239 && start + 2 < data.length) {
                // 224 = 11100000;  239 = 11101111
                if (data[start + 1] >= 128 && data[start + 1] < 192 && data[start + 2] >= 128 && data[start + 2] < 192) {
                    start += 3;
                    continue;
                }
            } else if (data[start] >= 240 && data[start] <= 247 && start + 3 < data.length) {
                // 240 = 11110000;  247 = 11110111
                if (data[start + 1] >= 128 && data[start + 1] < 192 &&
                        data[start + 2] >= 128 && data[start + 2] < 192 &&
                        data[start + 3] >= 128 && data[start + 3] < 192) {
                    start += 4;
                    continue;
                }
            }
            return false;
        }
        return true;
    }
}
