# My Personal Portfolio Backend

自分の履歴と職務経歴データを表すようなRESTful APIを実装。

A RESTful API built with Spring Boot to serve my personal portfolio data.


## 📅 Project Log

### 2025-08-23(土)

**Task: Backend 環境構築・設定 と テスト用 API エンドポイント**

* 環境構築・初期化
* アプリケーションを **PostgreSQL** DBに 接続。
*  **JPA Entity**の (`User` と `Project`) 作成。
*  `User` と `Project`の1対多関係を表すために  `@OneToMany` と `@ManyToOne` アノテーションの利用。
*  **Spring Data JPA repositories**の (`UserRepository` と `ProjectRepository`) を実装（データベースアクセスのため）。
*  **テスト用 RESTful API エンドポイント** (`/api/test`) を実装、JSONデータの返却が成功でした。

---

### 2025-08-24（日）

**Task: User情報取得用APIエンドポイントの実装**

* テスト用APIの実装をコピーし、User情報取得用APIエンドポイントを実装
* アノテーションが動かない問題を解決のため、`pom.xml`ファイルに`Lombok`バージョンを明確に指定した。
* プロジェクト情報を除き、ユーザー情報のみ取得するのに、中間に`UserDto`クラス作成
* テストを実施、設計したJSONデータと同じようなフォーマットの返却が成功でした。

---

### 2025-08-26（火）

**Task: Project情報取得用APIエンドポイントの実装**

* Project情報取得用APIエンドポイントを実装
* `ProjectDto`クラス実装
* Projectの生データに`Lessonleanred`と`TechStack`フィールドがStringデータ型であり、リスト出力の設計と異なったので、データを加工するため、`ProjecService`クラスを追加で実装した。
* テストを実施、設計したJSONデータと同じようなフォーマットの返却が成功でした。

### 2025-08-28（火）

**Task: Fileダウンロード用APIエンドポイントの実装**

* Fileダウンロード用APIエンドポイントを実装
* ファイル処理のため`FileService`クラス実装（今後エクセルファイルも対応）
* APIエンドポイントの`FileController`クラス実装
* テストを実施、pdf崩れなくダウンロード成功