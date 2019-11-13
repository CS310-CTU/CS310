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


