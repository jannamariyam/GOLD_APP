from django.conf.urls import url
from account import views
urlpatterns=[
    url(r'^register/',views.addaccount),
    url(r'^penalty/',views.penalty),
    url(r'^view/',views.viewaccount,name='view_re'),
    url(r'^update/(?P<idd>\w+)',views.editaccount, name='updateacc'),
    url(r'^delete/(?P<idd>\w+)',views.delaccount,name='delacc'),
]