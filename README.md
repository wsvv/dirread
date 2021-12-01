# dirread
2020操作系统大作业 Linux打印进程树
在Linux下利用Java实现的进程树打印，以达到pstree -p命令的效果，主要通过/proc下的目录中的进程文件，找到所有数字目录，在数字目录访问status文件，读取文件中的进程信息内容（Name，Pid，PPid）建立成树形结构并展现。
 
![123](https://user-images.githubusercontent.com/51820921/144194501-9a56b26f-8eae-46bc-962d-f33b0210923f.png)


贡献者QXK ZW
