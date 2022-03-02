from django.conf.urls import url
from . import views
urlpatterns=[

    url(r'^android1/',views.mapiview1.as_view()),
    url(r'^viewplan/',views.mapiview2.as_view()),
    url(r'^viewdue/',views.pendingview),
    url(r'^dueentry/(?P<idd>\w+)',views.senddue,name='dueentry'),
# url(r'^delete/(?P<idd>\w+)',views.delaccount,name='delacc'),


]