package com.jiang.redis.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

/**
 * DESC: 验证码图片生成工具
 *
 * @version 0.1.0
 */
public class VerifyCodeUtils {

    private static String[] seedArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

    private static Random random = new Random();

    public static ByteArrayInputStream generateImage(String verifyCode, int width, int height) {

        BufferedImage image = new BufferedImage(width, height, 1);
        Graphics g = image.getGraphics();
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", 2, 28));
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        char[] codes = verifyCode.toCharArray();
        for (int i = 0; i < codes.length; i++) {
            g.setColor(new Color(20 + random.nextInt(110),
                    20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(String.valueOf(codes[i]), 20 * i + 10, 30);
        }
        g.dispose();

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            ImageOutputStream imageOut = ImageIO
                    .createImageOutputStream(output);
            ImageIO.write(image, "JPEG", imageOut);
            imageOut.close();
            input = new ByteArrayInputStream(output.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException("验证码图片生成异常!", e);
        }

        return input;
    }

    /**
     * 获取验证码
     * @param length
     * @return
     */
    public static String getVerifyCodeString(int length) {
        StringBuilder verifyCode = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(seedArray.length);
            verifyCode.append(seedArray[index]);
        }
        return verifyCode.toString();
    }

    private static Color getRandColor(int fc, int bc) {
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }


}
