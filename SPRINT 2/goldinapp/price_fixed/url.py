from django.conf.urls import url
from price_fixed import views
urlpatterns=[
    url(r'^post_price/',views.post_price),
    url(r'^view_price/',views.view_price),
    url(r'^updt_price/(?P<idd>\w+)',views.update, name='updt'),
    url(r'^delete/(?P<idd>\w+)',views.delete,name='delete'),
    url(r'^android/', views.pfapiview.as_view()),

]