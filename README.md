# CS310
CS310 - mobile app programming - Colorado Tech University - Fall 2019

Setting git on Windows
----------------------
1. Download / install git for Windows: https://gitforwindows.org

2. Open up your git bash utility

3. Clone the CS310 project / repository: git clone https://github.com/CS310-CTU/CS310.git

4. Add upstream: git remote add upstream https://github.com/CS310-CTU/CS310.git

5. Check your repo setup: git remote -v

Should look like this:

$ git remote -v
origin	https://github.com/CS310-CTU/CS310.git (fetch)
origin	https://github.com/CS310-CTU/CS310.git (push)
upstream	https://github.com/CS310-CTU/CS310.git (fetch)
upstream	https://github.com/CS310-CTU/CS310.git (push)

Some git commands
-----------------

1.  This should always be run before you do any work:  git pull upstream master
   
    This gets the latest file updates/changes from 
    master branch

2.  Check status to see what changes you have done:  git status

If you make a change here is how you would get it uploaded/pushed to master:
1.  git status		(check what changes you are pushing)

2.  git add <file you want to push to master>
    or alternatively you can do the following:
    git add -A		(adds all files you want to push to master)

3.  git commit -m "<add a short summary of change>"

4.  git push		(pushes change to master)


---------------------------------------------------------------------------
Example:

----------------------------------- 1 -------------------------------------

$ git status
On branch master
Your branch is up to date with 'origin/master'.

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

        modified:   README.md

no changes added to commit (use "git add" and/or "git commit -a")


----------------------------------- 2 -------------------------------------

$ git add README.md

$ git status
On branch master
Your branch is up to date with 'origin/master'.

Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

        modified:   README.md

----------------------------------- 3 -------------------------------------

$ git commit -m "Updated README.md file info"
[master 93bf6c6] Updated README.md file info
 1 file changed, 42 insertions(+)

$ git status
On branch master
Your branch is ahead of 'origin/master' by 1 commit.
  (use "git push" to publish your local commits)

nothing to commit, working tree clean

----------------------------------- 4 -------------------------------------

$ git push
Counting objects: 3, done.
Delta compression using up to 8 threads.
Compressing objects: 100% (2/2), done.
Writing objects: 100% (3/3), 867 bytes | 867.00 KiB/s, done.
Total 3 (delta 0), reused 0 (delta 0)
To https://github.com/CS310-CTU/CS310.git
   7ed9273..93bf6c6  master -> master



Test
