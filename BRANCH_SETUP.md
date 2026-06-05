# Git Branch Setup Instructions

## Run these commands after cloning the repository

```bash
# 1. Clone the repo
git clone https://github.com/YOUR_USERNAME/MediaHub.git
cd MediaHub

# 2. Create all module branches
git checkout -b develop
git push origin develop
git checkout main

git checkout -b feature/IAM
git push origin feature/IAM
git checkout main

git checkout -b feature/ContentCatalog
git push origin feature/ContentCatalog
git checkout main

git checkout -b feature/Editorial
git push origin feature/Editorial
git checkout main

git checkout -b feature/Licensing
git push origin feature/Licensing
git checkout main

git checkout -b feature/Royalty
git push origin feature/Royalty
git checkout main

git checkout -b feature/Analytics
git push origin feature/Analytics
git checkout main

git checkout -b feature/Notifications
git push origin feature/Notifications
git checkout main

git checkout -b feature/Subscription
git push origin feature/Subscription
git checkout main

# 3. Switch to your module branch (Editorial)
git checkout feature/Editorial

# 4. After coding — commit and push
git add .
git commit -m "Added POST /reviews API — EditorialReview entity"
git push origin feature/Editorial
```

## Branch Names
| Branch                  | Owner    | Purpose                        |
|-------------------------|----------|--------------------------------|
| main                    | All      | Stable production code         |
| develop                 | All      | Integration branch             |
| feature/IAM             | Member 1 | IAM module development         |
| feature/ContentCatalog  | Member 2 | Content Catalog development    |
| feature/Editorial       | Member 3 | Editorial module development   |
| feature/Licensing       | Member 4 | Licensing module development   |
| feature/Royalty         | Member 5 | Royalty module development     |
| feature/Analytics       | Member 6 | Analytics module development   |
| feature/Notifications   | Member 7 | Notifications module development|
