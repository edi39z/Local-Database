# Local Database Application

Aplikasi **Local Database** adalah aplikasi Android sederhana yang memungkinkan pengguna untuk menambahkan dan mengelola pekerjaan rumah (homework). Aplikasi ini dibuat menggunakan **Android Studio**, dengan bahasa pemrograman **Kotlin** dan menggunakan **SQLite** sebagai basis data lokal.

## Fitur Utama
- **Tambah Pekerjaan Rumah**: Pengguna dapat menambahkan tugas baru dengan judul dan deskripsi.
- **Hapus Tugas**: Tugas yang tidak diperlukan lagi dapat dihapus dengan menekan tombol delete.
- **Database Lokal**: Data tugas disimpan menggunakan SQLite untuk memastikan data tetap tersedia secara offline.

## Prasyarat
Sebelum menjalankan aplikasi, pastikan Anda telah menginstal:
- **Android Studio** versi terbaru
- SDK Android (minimal versi API 21 atau Android 5.0)
- Emulator atau perangkat fisik untuk menjalankan aplikasi

## Struktur Proyek
- **Activities**:
  - `HomeworkActivity`: Menampilkan daftar pekerjaan rumah.
  - `AddHomeworkActivity`: Untuk menambahkan tugas baru ke dalam daftar.
- **Layouts**:
  - `activity_homework.xml`: Layout untuk halaman daftar tugas.
  - `activity_add_homework.xml`: Layout untuk menambahkan tugas.
- **Database**:
  - Menggunakan SQLite untuk penyimpanan data lokal.
- **Strings**:
  - Semua teks aplikasi menggunakan string resource untuk mendukung i18n (internationalization).


