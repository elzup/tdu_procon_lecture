cmake_minimum_required(VERSION 3.5)
project(cpp)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES ex04_binary_search_sqrt.cpp)
add_executable(cpp ${SOURCE_FILES})