from rest_framework import serializers
from .models import Closereq
class mserializer(serializers.ModelSerializer):

    class Meta:
        model=Closereq
        fields='__all__'