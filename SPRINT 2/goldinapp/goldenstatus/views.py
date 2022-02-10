from django.shortcuts import render
from goldenstatus.models import GoldStatus
from django.core.files.storage import FileSystemStorage

# Create your views here.
def post_update(request):
    if request.method=="POST":
        obj=GoldStatus()
        myfile = request.FILES['img']
        fs = FileSystemStorage()
        filename = fs.save("back.jpg", myfile)
        obj.image = "back.jpg"
        obj.pergram=request.POST.get('gram')
        obj.pavan=request.POST.get('pavam')
        obj.save()

    return render(request,'goldenstatus/post_update.html')

def view_update(request):
    obj=GoldStatus.objects.all()
    context={
        'objval':obj
    }
    return render(request,'goldenstatus/view_update.html',context)

def update(request):
    obj=GoldStatus.objects.all()
    context={
        'objval':obj
    }
    if request.method=="POST":
        # if len(obj)>0:
        #     ob=obj[0]
        # else:
        # ob=GoldStatus()
        ob=GoldStatus.objects.get(g_id=1)
        # obj.pavan=request.POST.get('pavan')
        # obj.pergram=request.POST.get('gram')
        myfile = request.FILES['img']
        fs = FileSystemStorage()
        filename = fs.save(myfile.name, myfile)
        ob.image = myfile.name
        # myfile = request.FILES['img']
            # fs = FileSystemStorage()
            # filename = fs.save("back.jpg", myfile)
            # ob.image = "back.jpg"
        ob.save()
        obj = GoldStatus.objects.all()
        context = {
            'objval': obj
        }
        # return update(request)
        return render(request,'goldenstatus/update.html',context)
    return render(request,'goldenstatus/update.html',context)

def delete(request,idd):
    ob=GoldStatus.objects.get(g_id=idd)
    ob.delete()
    return view_update(request)

def add(request):
    if request.method=="POST":
       ob=GoldStatus()
       ob.pavan=request.POST.get('pavan')
       ob.pergram=request.POST.get('gram')
       myfile = request.FILES['img']
       fs = FileSystemStorage()
       filename = fs.save(myfile.name, myfile)
       ob.image = myfile.name
       ob.save()
    return render(request,'goldenstatus/add_gold.html')
