from django.shortcuts import render
from .models import Reward
from django.http import HttpResponse,HttpResponseRedirect
# Create your views here.
def post_reward(request):

    if request.method=="POST":
        obj=Reward()
        obj.rduration= request.POST.get('duration')
        obj.type=request.POST.get('type')
        obj.plan=request.POST.get('plan')
        obj.rper=request.POST.get('per')
        obj.save()
        return view_reward(request)
        # return HttpResponseRedirect('/reward/view_re/')


    return render(request,'reward/rewardentry.html')
def view_reward(request):
    objs = Reward.objects.all()
    context = {
        'abc': objs,
    }
    return render(request, 'reward/viewreward.html', context)

def del_reward(request,idd):
    obj=Reward.objects.get(rwid=idd)
    obj.delete()
    return view_reward(request)
