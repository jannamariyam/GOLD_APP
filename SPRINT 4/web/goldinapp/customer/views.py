from django.shortcuts import render

# Create your views here.
from .mserializer import mserializer
from rest_framework.response import Response
from django.http import HttpResponse
from rest_framework.views import APIView
from .models import Customer
from login.models import Login
import datetime
class mapiview(APIView):
    def get(self,request):
        s=Customer.objects.all()
        ser=mserializer(s,many=True)
        return Response(ser.data)
    def post(self,request):
        obj=Customer()
        obj.name = request.data["name"]
        obj.phone = request.data["phone"]
        obj.email = request.data["email"]
        obj.dob = request.data["dob"]
        obj.nominee = request.data["nomi"]
        obj.nph = request.data["nph"]
        obj.aadr = request.data["aad"]
        obj.pin = request.data["pin"]
        obj.dist = request.data["dist"]
        obj.acc = request.data["acc"]
        obj.jdate = datetime.date.today()

        objl=Login()
        objl.uname = request.data["un"]
        objl.pwd=request.data["pwd"]
        objl.utype="customer"
        objl.save()

        obj.lid=objl.uid
        obj.save()
        return HttpResponse("Successfull")
class mapiview1(APIView):
    def get(self,request):
        s=Customer.objects.all()
        ser=mserializer(s,many=True)
        return Response(ser.data)
    def post(self,request):
        lid = request.data["uid"]
        s = Customer.objects.filter(lid=lid)
        ser = mserializer(s, many=True)
        return Response(ser.data)

class mapiview2(APIView):
    def get(self,request):
        s=Customer.objects.all()
        ser=mserializer(s,many=True)
        return Response(ser.data)
    def post(self,request):
        obj=Customer()
        lid = request.data["userid"]
        # print(obj.cusid)
        objlog=Customer.objects.get(lid=lid)
        obj.cusid = objlog.cusid
        obj.name = request.data["name"]
        obj.phone = request.data["phone"]
        obj.email = request.data["email"]
        obj.dob = request.data["dob"]
        obj.nominee = request.data["nomi"]
        obj.nph = request.data["nph"]
        obj.aadr = request.data["aad"]
        obj.pin = request.data["pin"]
        obj.dist = request.data["dist"]
        obj.acc = request.data["acc"]
        obj.jdate = datetime.date.today()
        obj.lid=lid

        obj.save()

        objl=Login()
        objl.uid=objlog.lid
        objl.uname = request.data["un"]
        objl.pwd=request.data["pwd"]
        objl.utype="customer"
        objl.save()
        return HttpResponse("Successfull")

def vcustomer(request):
    obj=Customer.objects.all()
    # obj = Customer.objects.filter(fixed_id=idd)
    context = {
            'objval': obj
    }
        # if request.method == "POST":
        #     ob = PriceFixed()
        #     ob.amound = request.POST.get('amound')
        #     ob.save()
    return render(request, 'customer/view customer details.html', context)

def post(request):
    if request.method=="POST":
        objl = Login()

        objl.uname = request.POST.get('uname')
        objl.pwd = request.POST.get('pwd')
        objl.utype = "customer"
        objl.save()

        obj=Customer()
        # lid = request.post.get("userid")
            # print(obj.cusid)
        # objlog=Customer.objects.get(lid=lid)
        # obj.cusid = objlog.cusid
        obj.name = request.POST.get('name')
        obj.phone = request.POST.get('ph')
        obj.email = request.POST.get('email')
        obj.dob = request.POST.get('dob')
        obj.nominee = request.POST.get('nomi')
        obj.nph = request.POST.get('nph')
        obj.aadr = request.POST.get('adr')
        obj.pin = request.POST.get('pin')
        obj.dist = request.POST.get('dist')
        obj.acc = request.POST.get('acc')
        obj.jdate = datetime.date.today()
        obj.lid=objl.uid


        obj.save()


        return vcustomer(request)
    return render(request,'customer/reg_customer.html')
from payments.models import Payments
def viewtr(req,idd):
    objs=Payments.objects.filter(cusid=idd)
    context={
        'vald':objs,
    }
    return render(req,'customer/cus_transaction.html',context)