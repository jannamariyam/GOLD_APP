from django.shortcuts import render
from .models import Accountdb
# Create your views here.
def addaccount(request):
    if request.method=="POST":
        obj=Accountdb()
        obj.accname=request.POST.get('name')
        obj.acc_no=request.POST.get('accno')
        obj.bank=request.POST.get('bank')
        obj.ifsc=request.POST.get('ifsc')
        obj.save()
        return viewaccount(request)
    return render(request,'account/addaccount.html')

def viewaccount(request):
    objs=Accountdb.objects.all()
    context={
        'abc':objs,
    }
    return render(request,'account/viewaccount.html',context)

def delaccount(request,idd):
    obj=Accountdb.objects.get(slno=idd)
    obj.delete()
    return viewaccount(request)

def editaccount(request,idd):
    obj = Accountdb.objects.get(slno=idd)
    context = {
        'abc': obj,
    }

    if request.method=="POST":
        obj = Accountdb()
        obj.slno=idd
        obj.accname = request.POST.get('name')
        obj.acc_no = request.POST.get('accno')
        obj.bank = request.POST.get('bank')
        obj.ifsc = request.POST.get('ifsc')
        obj.save()
        return viewaccount(request)

    return render(request, 'account/editaccount.html',context)

from account.models import Penalty
def penalty(request):
    if request.method=="POST":
        ob=Penalty()
        ob.package=request.POST.get('package')
        ob.type=request.POST.get('type')
        ob.penalty=request.POST.get('penalty')
        ob.save()
    return render(request,'account/update_penality.html')