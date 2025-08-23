# My Personal Portfolio Backend

A RESTful API built with Spring Boot to serve my personal portfolio data.

## 📅 Project Log

### 2025-08-24

**Task: Backend 環境設定 と テスト用 API エンドポイント**

* 環境構築・初期化
* アプリケーションを **PostgreSQL** DBに 接続。
*  **JPA Entity**の (`User` と `Project`) 作成。
*  `User` と `Project`の1対多関係を表すために  `@OneToMany` と `@ManyToOne` アノテーションの利用。
*  **Spring Data JPA repositories**の (`UserRepository` と `ProjectRepository`) を実装（データベースアクセスのため）。
*  **テスト用 RESTful API エンドポイント** (`/api/test`) を実装、JSONデータの返却が成功でした。

---

### 2025-08-25

**Task: User情報取得用APIエンドポイントの実装**

* [詳細は当日更新]