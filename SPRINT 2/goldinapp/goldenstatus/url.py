from django.conf.urls import url
from goldenstatus import views
urlpatterns=[
    url(r'^post_update/',views.post_update),
    url(r'^view_update/',views.view_update),
    # url('update/(?P<idd>\w+)',views.update,name='update'),
    url(r'^update/', views.update, name='update'),
    url(r'^delete/(?P<idd>\w+)',views.delete,name='delete'),
    url(r'^add/',views.add),
]