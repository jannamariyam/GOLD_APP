from django.conf.urls import url
from price_fixed import views
urlpatterns=[
    url('post_price/',views.post_price),
    url('view_price/',views.view_price),
    url('updt_price/(?P<idd>\w+)',views.update, name='updt'),
    url('delete/(?P<idd>\w+)',views.delete,name='delete'),
]