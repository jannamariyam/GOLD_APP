from django.shortcuts import render

# Create your views here.
from .mserializer import mserializer
from .models import Payments
from rest_framework.response import Response
from django.http import HttpResponse
from rest_framework.views import APIView
import datetime
from PIL import Image
from base64 import decodestring
from goldinapp import settings
import io, base64
class mapiview1(APIView):
    # def get(self,request):
    #     pass
    #     # s=Customer.objects.all()
    #     # ser=mserializer(s,many=True)
    #     # return Response(ser.data)
    def post(self,request):
        obj=Payments()
        obj.cusid_id= request.data["uid"]
        obj.date = datetime.date.today()
        obj.plid_id =request.data["plan"]
        obj.amout =request.data["amount"]
        obj.inst = request.data["inst"]
        b64 = request.data["img"]

        obj.image = "test.jpg"
        obj.status= "Paid"
        obj.save()

        fname=str(settings.BASE_DIR)+(settings.STATIC_URL)+"payments/"+str(obj.payid) +".jpg"
        image = base64.b64decode(b64)
        img = Image.open(io.BytesIO(image))
        img.save(fname, 'jpeg')
        # image.save(fname)

        return HttpResponse("Saved Successfully")

from django.db.models import Sum
from price_fixed.models import PriceFixed
class mapiview2(APIView):
    # def get(self,request):
    #     pass
    #     # s=Customer.objects.all()
    #     # ser=mserializer(s,many=True)
    #     # return Response(ser.data)
    def post(self,request):
        price=PriceFixed.objects.all()
        gm=price[0].gamount
        plan = request.data["plan"]
        print("plan")
        print(plan)
        pay=Payments.objects.filter(plid_id=plan,status='Accept')
        print("len")
        print(len(pay))
        total_price = sum(pay.values_list('amout', flat=True))
        print("total")
        print(total_price)
        print("gram")
        print(gm)

        gms=float(total_price)/float(gm)

        return HttpResponse(str(gms))

class mapiview3(APIView):
    # def get(self,request):
    #     pass
    #     # s=Customer.objects.all()
    #     # ser=mserializer(s,many=True)
    #     # return Response(ser.data)
    def post(self,request):
        price=PriceFixed.objects.all()
        gm=price[0].gamount
        plan = request.data["plan"]
        print("plan")
        print(plan)
        pay=Payments.objects.filter(plid_id=plan,status='Accept')
        print("len")
        print(len(pay))
        total_price = sum(pay.values_list('amout', flat=True))
        print("total")
        print(total_price)
        print("gram")
        print(gm)

        gms=float(total_price)/float(gm)

        return HttpResponse(str(gms)+"#"+str(total_price)+"#"+str(len(pay)))

def viewpayments(request):
    objs=Payments.objects.filter(status='Paid')
    context={
        'objs':objs,
    }
    return render(request,'payments/viewpayments.html',context)
from planpay.models import PlanPay
def accept(request,idd):
    obj=Payments.objects.get(payid=idd)
    obj.status="Accept"
    obj.save()

    objinst=PlanPay.objects.get(plid=obj.plid_id,slno=obj.inst)
    objinst.status="Paid"
    objinst.save()

    return viewpayments(request)
def reject(request,idd):
    obj=Payments.objects.get(payid=idd)
    obj.status="Reject"
    obj.save()
    return viewpayments(request)

