from django.conf.urls import url
from . import views
urlpatterns=[
   url(r'^android1/',views.mapiview1.as_view()),
   url(r'^reqview/',views.closereq),
   url(r'^approve/(?P<idd>\w+)', views.approve)
]