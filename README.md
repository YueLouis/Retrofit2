# Bài tập Retrofit2 – Android

Đây là bài tập cá nhân môn **An toàn mạng không dây và di động / Android Networking** sử dụng **Retrofit2** để gọi API và hiển thị dữ liệu bằng **RecyclerView**.

## 1. Mô tả bài toán

- Gọi API từ server theo yêu cầu của giảng viên:
  - **Base URL:** `http://app.iotstar.vn:8081/appfoods/`
  - **Endpoint:** `categories.php`
- Nhận dữ liệu JSON danh sách **loại món ăn** (Beef, Chicken, Dessert, …).
- Parse JSON sang model `Category` bằng **Gson converter**.
- Hiển thị danh sách bằng `RecyclerView` + `CardView`.
- Khi người dùng **chọn một item**, ứng dụng hiển thị `Toast` dạng:

> Bạn chọn \<Tên category\>

## 2. Công nghệ sử dụng

- **Ngôn ngữ:** Java  
- **AndroidX:** AppCompat, RecyclerView, CardView  
- **Networking:** Retrofit2 + OkHttp3 logging-interceptor  
- **JSON converter:** Gson Converter  
- **UI:** ConstraintLayout, CardView

Các dependency chính trong `build.gradle.kts (Module: app)`:

```kotlin
implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")
implementation("com.squareup.okhttp3:logging-interceptor:3.12.0")

implementation("com.github.bumptech.glide:glide:4.14.2")
annotationProcessor("com.github.bumptech.glide:compiler:4.14.2")
```

## 3. Cấu trúc chính của project

Retrofit2/
 ├─ app/
 │   ├─ src/main/java/vn/hcmute/retrofit2/
 │   │   ├─ MainActivity.java        # Gọi API, hiển thị RecyclerView
 │   │   ├─ Category.java            # Model ánh xạ JSON
 │   │   ├─ APIService.java          # Khai báo endpoint Retrofit
 │   │   ├─ BaseClient.java          # Tạo Retrofit client dùng chung
 │   │   ├─ ApiClient.java           # Cung cấp APIService với BASE_URL
 │   │   └─ CategoryAdapter.java     # Adapter cho RecyclerView
 │   └─ src/main/res/
 │       ├─ layout/activity_main.xml # RecyclerView
 │       └─ layout/item_category.xml # CardView hiển thị từng category
 └─ docs/
     └─ screenshots/
         ├─ anh_01.png               # Màn hình danh sách category
         └─ anh_02.png               # Màn hình khi click và hiện Toast
         
## 4. Cách chạy ứng dụng
Mở project bằng Android Studio.

Đảm bảo đã bật Internet trên thiết bị / emulator.

Bấm Run và chọn thiết bị.

Ứng dụng sẽ:

Gọi API http://app.iotstar.vn:8081/appfoods/categories.php

Hiển thị danh sách loại món ăn.

Khi bấm vào một item, hiện Toast thông báo loại đã chọn.
