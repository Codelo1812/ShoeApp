package com.example.nhom10;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class Utils {
    public static Bitmap convertToBitmapFromAssets(Context context, String nameImage) {
        if (nameImage == null || nameImage.trim().isEmpty()) {
            Log.e("BitmapUtils", "Invalid image name");
            return null;
        }

        AssetManager assetManager = context.getAssets();
        Bitmap bitmap = null;

        try (InputStream inputStream = assetManager.open("images/" + nameImage)) {
            // Đọc kích thước ảnh trước
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, null, options);

            // Tính toán tỉ lệ scale
            int width = options.outWidth;
            int height = options.outHeight;
            int maxSize = 1024;

            int inSampleSize = 1;
            if (width > maxSize || height > maxSize) {
                int halfWidth = width / 2;
                int halfHeight = height / 2;
                while ((halfWidth / inSampleSize) > maxSize || (halfHeight / inSampleSize) > maxSize) {
                    inSampleSize *= 2;
                }
            }

            // Decode lại ảnh với kích thước đã giảm
            options.inJustDecodeBounds = false;
            options.inSampleSize = inSampleSize;

            try (InputStream inputStream2 = assetManager.open("images/" + nameImage)) {
                bitmap = BitmapFactory.decodeStream(inputStream2, null, options);
            }
        } catch (IOException e) {
            Log.e("BitmapUtils", "Error loading image: " + nameImage, e);
        }

        return bitmap;
    }
}
