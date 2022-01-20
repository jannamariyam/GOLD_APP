from django.shortcuts import render
from temp.models import Login
# Create your views here.
def adminhome(request):
    return render(request,'temp/admin.html')
def login(request):

    if request.method=="POST":
        un=request.POST.get("uname")
        pwd = request.POST.get("pwd")
        objs=Login.objects.filter(uname=un,pwd=pwd)
        if len(objs)>0:
            return render(request, 'temp/admin.html')
    return render(request,'temp/login.html')
