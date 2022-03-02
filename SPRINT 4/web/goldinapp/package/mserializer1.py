from rest_framework import serializers
from .models import Variable
class mserializer1(serializers.ModelSerializer):

    class Meta:
        model=Variable
        fields='__all__'