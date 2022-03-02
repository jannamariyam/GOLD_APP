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

    objs=Penalty.objects.filter(pn_id=1)
    per="0"
    if len(objs)>0:
        per=objs[0].penalty
    context={
        "per":per
    }

    if request.method=="POST":
        ob=Penalty()
        ob.pn_id=1
        ob.package=""
        ob.type=""
        ob.penalty=request.POST.get('penalty')
        context = {
            "per": ob.penalty
        }
        ob.save()
    return render(request,'account/update_penality.html',context)
from payments.models import Payments
from django.db.models import Sum
from goldenstatus.models import GoldStatus
from price_fixed.models import PriceFixed
def viewreport(request):
    pamt = 0
    gamt = 0
    gpur = 0
    if request.method=="POST":
        dt=request.POST.get('date')
        

        pamt=Payments.objects.filter(date=dt).aggregate(Sum('amout'))['amout__sum']
        obj = PriceFixed.objects.all()
        if len(obj)>0:
            try:
                ob=obj[0]

                gamt=ob.gamount
                print(gamt)
                print(pamt)
                gpur=pamt/gamt
            except:
                pass
    context = {
        'coll': pamt,
        'gpur': gpur
    }


    return render(request,'account/report.html',context)

    # pass