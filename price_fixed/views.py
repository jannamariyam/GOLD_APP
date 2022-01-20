from django.shortcuts import render
from price_fixed.models import PriceFixed
from django.http import HttpResponseRedirect
# Create your views here.
def post_price(request):
    obs = PriceFixed.objects.all()
    if len(obs) > 0:
        obj = obs[0]
        context = {
            'gm': obj.gamount,
            'pm': obj.pamount,

        }
    else:
        context = {
            'gm': "",
            'pm': "",

        }
    if request.method=="POST":

        obs=PriceFixed.objects.all()
        context = {
            'gm': "",
            'pm': "",

        }
        if len(obs)>0:
            obj=obs[0]
            context = {
                'gm': obj.gamount,
                'pm': obj.pamount,

            }
        else:
            obj=PriceFixed()
        obj.gamount=request.POST.get('amund')
        obj.pamount = request.POST.get('pamund')
        obj.save()
        return HttpResponseRedirect('price_fixed/post_price.html',context)
    return render(request,'price_fixed/post_price.html',context)
def view_price(request):
    obj=PriceFixed.objects.all()
    context={
        'abc':obj
    }
    return render(request,'price_fixed/view_price.html',context)

def update(request,idd):
    obj=PriceFixed.objects.filter(fixed_id=idd)
    context={
        'objval':obj
    }
    if request.method=="POST":
        ob=PriceFixed()
        ob.amound=request.POST.get('amound')
        ob.save()
    return render(request,'price_fixed/updt_price.html',context)
def delete(request,idd):
    ob = PriceFixed.objects.get(fixed_id=idd)
    ob.delete()
    return view_price(request)